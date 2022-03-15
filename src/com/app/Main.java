package com.app;
import com.app.Controller.AppOpener;
import com.app.Controller.JdbcUtil;
import com.app.View.App;

public class Main {

    private static AppOpener appOpener;
    public Main(App app){
        this.appOpener = appOpener;
    }

    public static void main(String[] args) {
        JdbcUtil.getInstance();
        appOpener.opener();
    }
}
