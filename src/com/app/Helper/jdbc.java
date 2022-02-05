package com.app.Helper;

import java.sql.*;

import static com.app.Helper.Config.*;

public class jdbc {
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
        jdbc db = new jdbc();
        return db.connectDB();
    }
}
