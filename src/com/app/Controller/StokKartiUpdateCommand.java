package com.app.Controller;

import com.app.Model.StokKartlari;
import com.app.View.App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiUpdateCommand implements ActionListener {

    private static App app;
    public StokKartiUpdateCommand(App app){
        this.app = app;
    }

    public void update(){
        StokKartlari stokKartlari = StokKartiSaveCommand.getFieldData();
        app.dataCollector.updateStokKarti(stokKartlari);
        app.stokKartlariList = app.filtredStokKartlariList = app.dataCollector.getStokKartiList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        StokKartiListCommand.list();
    }
}
