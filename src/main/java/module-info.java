module com.example.l2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.l2 to javafx.fxml;
    exports com.example.l2;
}