
import java.sql.*;
import javax.swing.*;

import com.mysql.cj.xdevapi.Result;

public class database extends NerdyGadgets {
    static String username = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/nerdygadgets2";

    public database() {
        System.out.println("Database class is called");
    }

    public static void start_return(String returnstatus, int ordernumber, String productname, int amount, String returnlocation, String notes, int returntype, String reason){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO returns (returnstatus, ordernumber, productid, amount, returnlocation, notes, returntype, reason) VALUES (?, ?, (SELECT productid FROM product WHERE name = ?), ?, ? ,?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, returnstatus);
            statement.setInt(2, ordernumber);
            statement.setString(3, productname);
            statement.setInt(4, amount);
            statement.setString(5, returnlocation);
            statement.setString(6, notes);
            statement.setInt(7, returntype);
            statement.setString(8, reason);
            System.out.println(statement); // Debugging
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void process_return(int returnid, String returnstatus){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE returns SET returnstatus = ? WHERE returnid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, returnstatus);
            statement.setInt(2, returnid);
            System.out.println(statement); // Debugging
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void print_returns() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String sql = "select returnid, returnstatus, ordernumber, name, amount, returnlocation, notes, returntype, reason from returns join product on returns.productid = product.productid";
            // Statement maken
            Statement statement = connection.createStatement();
            System.out.println(statement);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                // warehouse p = new warehouse(rs.getInt("location"), rs.getInt("productid"), rs.getInt("amount"));
                // rs.getString("location"));
                // warehouse.add(p);
                String d = rs.getString("returnid");
                String e = rs.getString("returnstatus");
                String f = rs.getString("ordernumber");
                String g = rs.getString("name");
                String h = rs.getString("reason");
                String i = rs.getString("amount");
                String j = rs.getString("returnlocation");
                String k = rs.getString("notes");
                String l = rs.getString("returntype");


                model2.addRow(new Object[]{d, e, f, g, h, i, j, k, l});
                // System.out.println(p);
            }
        

        } catch (SQLException e) {

        }
    }
    public static void print_warehouse() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String sql = "select location, name, amount from warehouse join product on warehouse.productid = product.productid";
            // Statement maken
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                // warehouse p = new warehouse(rs.getInt("location"), rs.getInt("productid"), rs.getInt("amount"));
                // rs.getString("location"));
                // warehouse.add(p);
                String d = rs.getString("location");
                String e = rs.getString("name");
                String f = rs.getString("amount");
                model.addRow(new Object[]{d, e, f});
                // System.out.println(p);
            }
        

        } catch (SQLException e) {

        }
    }
    public static void print_packages() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String sql = "select * from packages";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                packages p = new packages(rs.getInt("packageid"), rs.getString("destination"), rs.getString("Status"),
                rs.getString("location"));
                packagesTab.add(new JLabel(Integer.toString(rs.getInt("packageid")))); 
                packagesTab.add(new JLabel(rs.getString("destination")));
                packagesTab.add(new JLabel(rs.getString("Status")));
                packagesTab.add(new JLabel(rs.getString("location")));
                // System.out.println(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // default values for packages tab if database error occurs
            // package 1
            packagesTab.add(new JLabel("1"));
            packagesTab.add(new JLabel("ABC"));
            packagesTab.add(new JLabel("Pending"));
            packagesTab.add(new JLabel("Warehouse A"));

            // package 2
            packagesTab.add(new JLabel("2"));
            packagesTab.add(new JLabel("DEF"));
            packagesTab.add(new JLabel("In Transit"));
            packagesTab.add(new JLabel("Warehouse B"));

            // package 3
            packagesTab.add(new JLabel("3"));
            packagesTab.add(new JLabel("XYZ"));
            packagesTab.add(new JLabel("Delivered"));
            packagesTab.add(new JLabel("Customer"));
            System.out.println("Database error, using default values for packages");
        }
    }
    // add product method to add product to warehouse database.
    // usage: database.add_product(10, "productname", 1);
    // this will add 10 of productname to location 1 in the warehouse.
    // if the product already exists in the warehouse, the amount will be updated.
    // if the product does not exist in the warehouse, it will be added.
    // if the product does not exist in the product table, it will be added too.
    public static void add_product(int amount, String name, int location) {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            // Check if product exists
            String sql = "SELECT * FROM product WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            // System.out.println(statement); // Debugging
            ResultSet rs = statement.executeQuery();
            // If product does not exist, add it
            if (rs.next() == false){
                try {
                    String sql2 = "INSERT INTO product (name) VALUES (?)";
                    PreparedStatement statement2 = connection.prepareStatement(sql2);
                    statement2.setString(1, name);
                    // System.out.println(statement2); // Debugging
                    statement2.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try  {
                // Check if product is already in warehouse
                String sql5 = "SELECT * FROM warehouse WHERE location = ? AND productid IN (SELECT productid FROM product WHERE name = ?)";
                PreparedStatement statement5 = connection.prepareStatement(sql5);
                statement5.setInt(1, location);
                statement5.setString(2, name);
                // System.out.println(statement5); // Debugging
                ResultSet rs5 = statement5.executeQuery();
                if (rs5.next()){
                    try {
                        // If product is already in warehouse, update amount
                        String sql3 = "UPDATE warehouse SET amount = amount + ? WHERE location = ? AND productid IN (SELECT productid FROM product WHERE name = ?)";
                        PreparedStatement statement3 = connection.prepareStatement(sql3);
                        statement3.setInt(1, amount);
                        statement3.setInt(2, location);
                        statement3.setString(3, name);
                        // System.out.println(statement3); // Debugging
                        statement3.executeUpdate();
                        
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        // If product is not in warehouse, add it
                        String sql4 = "INSERT INTO warehouse (location, productid, amount) VALUES (?, (SELECT productid FROM product WHERE name = ?), ?)";
                        PreparedStatement statement4 = connection.prepareStatement(sql4);
                        statement4.setInt(1, location);
                        statement4.setString(2, name);
                        statement4.setInt(3, amount);
                        // System.out.println(statement4); // Debugging
                        statement4.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // remove product method to remove product from warehouse database.
    // usage: database.remove_product(10, "productname", 1);
    // this will remove 10 of productname from location 1 in the warehouse.
    // if the amount of product in the warehouse is less than the amount specified, the product will be removed from the warehouse.
    // if the product does not exist in the warehouse, nothing will happen.
    public static void remove_product(int amount, String name, int location) {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            try  {
                // Check amount of product in warehouse in specified location
                String sql5 = "SELECT * FROM warehouse WHERE location = ? AND productid IN (SELECT productid FROM product WHERE name = ?)";
                PreparedStatement statement5 = connection.prepareStatement(sql5);
                statement5.setInt(1, location);
                statement5.setString(2, name);
                // System.out.println(statement5);  // Debugging
                ResultSet rs5 = statement5.executeQuery();
                rs5.next();
                if (rs5.getInt("amount") > amount){
                    try {
                        // If not empty, update amount
                        String sql3 = "UPDATE warehouse SET amount = amount - ? WHERE location = ? AND productid IN (SELECT productid FROM product WHERE name = ?)";
                        PreparedStatement statement3 = connection.prepareStatement(sql3);
                        statement3.setInt(1, amount);
                        statement3.setInt(2, location);
                        statement3.setString(3, name);
                        // System.out.println(statement3); // Debugging
                        statement3.executeUpdate();
                        
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        // If empty, remove product from warehouse
                        String sql4 = "DELETE FROM warehouse WHERE productid = (SELECT productid FROM product WHERE name = ?) AND location = ?";
                        PreparedStatement statement4 = connection.prepareStatement(sql4);
                        statement4.setInt(2, location);
                        statement4.setString(1, name);
                        // System.out.println(statement4); // Debugging
                        statement4.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    