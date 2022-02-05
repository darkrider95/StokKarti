package com.app;

import com.app.Helper.jdbc;
import com.app.View.App;

public class Main {
    public static void main(String[] args) {
        jdbc.getInstance();
        App app = new App();
    }
}
