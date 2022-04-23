
package com.example.l2;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

import javafx.scene.control.TableColumn;

// import static javax.imageio.plugins.tiff.TIFFField.initData;

public class FXMLDocumentController implements Initializable {

    @FXML
    public TableColumn<Products, String> category;

    @FXML
    public TableColumn<Products, String>  description;

    @FXML
    private Label label;
    private final ObservableList<Products> productData = FXCollections.observableArrayList();

    @FXML
    private TableView<Products> tableProducts;

    @FXML
    private TableColumn<Products, Integer> id;

    @FXML
    private TableColumn<Products, String> name;

    @FXML
    private TableColumn<Products, BigDecimal> price;

    @FXML
    private TableColumn<Products, Integer> count;

    @FXML
    private TableColumn<Products, String> type;

    @FXML
    private void handleBattonAction(ActionEvent event) {
        //  id |    name     |  type   | category |           description    | count |  price
        id.setCellValueFactory(new PropertyValueFactory<Products, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
        type.setCellValueFactory(new PropertyValueFactory<Products, String>("type"));
        category.setCellValueFactory(new PropertyValueFactory<Products,String>("category"));
        description.setCellValueFactory(new PropertyValueFactory<Products,String>("description"));
        count.setCellValueFactory(new PropertyValueFactory<Products, Integer>("count"));
        price.setCellValueFactory(new PropertyValueFactory<Products, BigDecimal>("price"));

        tableProducts.setItems(productData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initData();
    }

    private void initData() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ais", "postgres", "123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * From products");
            while (rs.next()) {
                Products pr = new Products();
                //  id |    name     |  type   | category |           description    | count |  price
                pr.setId(rs.getInt("id"));
                pr.setName(rs.getString("name"));
                pr.setType(rs.getString("type"));
                pr.setCategory(rs.getString("category"));
                pr.setDescription(rs.getString("description"));
                pr.setCount(rs.getInt("count"));
                pr.setPrice(rs.getBigDecimal("price"));

                productData.add(pr);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
