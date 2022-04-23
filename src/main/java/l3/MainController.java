package l3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    Connection conn;
    Statement stmt;
    {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://45.10.244.15:55532/work100027", "work100027", "jGG*CL|1k9Xk04qjR%du");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private TextField titleTF;
    @FXML
    private TextField durationTF;
    @FXML
    private DatePicker datestartDP;
    @FXML
    private DatePicker datefinishDP;
    @FXML
    private ComboBox restrictionCB;
    @FXML
    private ComboBox genreCB;
    ObservableList<String> restrictionOptions =
            FXCollections.observableArrayList("0+",
                    "6+",
                    "12+",
                    "16+",
                    "18+"
            );
    private ObservableList<String> titlesData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        restrictionCB.getItems().addAll(restrictionOptions);
        restrictionCB.setVisibleRowCount(5);
        try {
            ResultSet rs = stmt.executeQuery("Select title From genre");
            while (rs.next()){
                titlesData.add(rs.getString("title"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        genreCB.getItems().addAll(titlesData);
        genreCB.setVisibleRowCount(7);
    }
    @FXML
    private void AddFilmButtonClick(ActionEvent event){
        try {
            PreparedStatement ps = conn.prepareStatement( "INSERT INTO film(title,duration,genre,restriction,datestart,datefinish) VALUES(?,?,?,?,?,?);" );
            ps.setString(1,titleTF.getText());
            ps.setInt(2,Integer.parseInt(durationTF.getText()));
            ps.setInt(3,getIdByTitle(genreCB.getValue().toString()) );
            ps.setInt(4,Integer.parseInt(restrictionCB.getValue().toString().substring(0,restrictionCB.getValue().toString().length()-1)));
            ps.setObject(5,datestartDP.getValue());
            ps.setObject(6,datefinishDP.getValue());
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getIdByTitle(String title){

        try {
            PreparedStatement ps = conn.prepareStatement("select id from genre where title=?");
            ps.setString(1,title);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                return rs.getInt("id");
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}