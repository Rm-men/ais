import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args){
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ais", "postgres", "123");
            // Statement stmt = conn.createStatement();
            // String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY
            // AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
            // CREATE TABLE Products ( Id INT PRIMARY KEY, ProductName VARCHAR(20), Price
            // INT );
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("INSERT INTO products(ProductName, Price) VALUES ('iPhone X', 76000), ('Galaxy S9', 45000), ('Nokia 9', 36000)");
            System.out.printf("Added %d rows", rows);
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
