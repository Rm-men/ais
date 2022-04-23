import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Ex1 {
    public static void main(String[] args) {
        /*
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/ais", "postgres", "123")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
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
        /*
         * Connection conn =
         * DriverManager.getConnection("jdbc:postgresql://localhost:5432/test",
         * "postgres", "123");
         * // Statement stmt = conn.createStatement();
         * // String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY
         * // AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
         * // CREATE TABLE Products ( Id INT PRIMARY KEY, ProductName VARCHAR(20), Price
         * // INT );
         * Statement statement = conn.createStatement();
         * int rows = statement.executeUpdate(
         * "INSERT Products(ProductName, Price) VALUES ('iPhone X', 76000), ('Galaxy S9', 45000), ('Nokia 9', 36000)"
         * );
         * System.out.printf("Added %d rows", rows);
         */
        // stmt.executeUpdate(sqlCommand);
        // List<String> names = new ArrayList<>();
        // names.add("Егор");

        // List<String> surnames = new ArrayList<>();
        // surnames.add("Кокорин");

        // Random rnd = new Random();
        // PreparedStatement ps = conn.prepareStatement(
        // "INSERT INTO employee(id_employee, firstname, lastname, age, salary)
        // VALUES(?,?,?,?,?);");
        // for (int i = 1; i <= 30; i++) {
        // ps.setInt(1, i);
        // ps.setString(2, names.get(rnd.nextInt(11)));
        // ps.setString(3, surnames.get(rnd.nextInt(13)));
        // ps.setInt(4, 18 + rnd.nextInt(38));
        // ps.setInt(5, 10000 + rnd.nextInt(60000) / 1000 * 1000);
        // ps.addBatch();
        // }
        // ps.executeBatch();

        // ResultSet rs = stmt.executeQuery("SELECT * FROM employee ORDER BY salary");
        // System.out.println("id\tname\tsurname\tage\tsalary");
        // while (rs.next()) {
        // System.out.print(rs.getInt("id_employee") + "\t"
        // + rs.getString("firstname") + "\t"
        // + rs.getString("lastname") + "\t"
        // + rs.getInt("age") + "\t"
        // + rs.getInt("salary") + "\n");
        // }

        // conn.close();

    }
}
