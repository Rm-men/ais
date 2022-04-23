module gestroo.ais3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens l3 to javafx.fxml;
    exports l3;
}