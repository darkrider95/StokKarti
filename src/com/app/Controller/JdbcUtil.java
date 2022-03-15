package com.app.Controller;
import java.sql.*;
import static com.app.Const.Config.*;

public class JdbcUtil {
    private Connection connect = null;
    public Connection connectDB() {
        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        System.out.println("Connecting database...");

        try {
            this.connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return this.connect;
    }

    public static Connection getInstance(){
        JdbcUtil db = new JdbcUtil();
        return db.connectDB();
    }
}
