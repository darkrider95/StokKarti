package com.app;
import com.app.View.App;
import com.app.Helper.JdbcUtil;
import com.app.View.App;

public class Main {
    public static void main(String[] args) {
        JdbcUtil.getInstance();
        App app = new App();
    }
}
