package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {
    public static void main (String[] args) throws Exception {

        String db = "users";
        String ip = "10.0.2.2";
        String port = "3306";
        String username = "admin";
        String password = "Root@123";

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://"+ip+":"+port+ "/"+ db;
        Connection con = DriverManager.getConnection(url,username,password);

        PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");

        ps.setString(1,"naman");
        ps.setString(2,"naman@gmail.com");
        ps.setString(3,"naman123");

        int executed = ps.executeUpdate();
        System.out.println(executed);

        ps.close();
        con.close();
    }
}
