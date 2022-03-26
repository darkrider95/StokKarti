package com.app;
import com.app.Controller.JdbcUtil;
import com.app.Controller.StokKartiFrameCommand;
import com.app.View.Depo;
import com.app.View.MainFrame;

public class Main {

    public static void main(String[] args) {
        JdbcUtil.getInstance();
        //MainFrame app = new MainFrame();
        //app.setVisible(true);
        //app.stokKarti.addActionListener(new StokKartiFrameCommand(app));
        Depo depo = new Depo();
    }
}
