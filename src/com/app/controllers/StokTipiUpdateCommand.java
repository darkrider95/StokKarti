package com.app.controllers;
import com.app.models.StokTipiModel;
import com.app.views.StokTipiFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokTipiUpdateCommand implements ActionListener {
    private StokTipiFrame iFrame;
    private StokTipiSaveCommand saveCommand;
    public StokTipiUpdateCommand(StokTipiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void update(){
        StokTipiModel stokTipiKartlari = saveCommand.getFieldData();
        iFrame.dataCollector.updateStokTipiKarti(stokTipiKartlari);
        iFrame.stokTipiList = iFrame.filtredStokTipiList = iFrame.dataCollector.getStokTipiList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}