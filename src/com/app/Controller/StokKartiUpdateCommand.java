package com.app.Controller;

import com.app.Model.StokKartlari;
import com.app.View.StokKartiFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiUpdateCommand implements ActionListener {

    private static StokKartiFrame app;
    public StokKartiUpdateCommand(StokKartiFrame app){
        this.app = app;
    }

    public void update(){
        //StokKartlari stokKartlari = .getFieldData();
        //app.dataCollector.updateStokKarti(stokKartlari);
        app.stokKartlariList = app.filtredStokKartlariList = app.dataCollector.getStokKartiList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        StokKartiListCommand.list();
    }
}
