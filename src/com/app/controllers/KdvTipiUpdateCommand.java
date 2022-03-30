package com.app.controllers;
import com.app.models.BirimKartiModel;
import com.app.models.KdvTipiModel;
import com.app.views.KdvTipiFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KdvTipiUpdateCommand implements ActionListener {
    private KdvTipiFrame iFrame;
    private KdvTipiSaveCommand saveCommand;
    public KdvTipiUpdateCommand(KdvTipiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void update(){
        KdvTipiModel kdvTipiKartlari = saveCommand.getFieldData();
        iFrame.dataCollector.updateKdvTipiKarti(kdvTipiKartlari);
        iFrame.kdvTipiList = iFrame.filtredKdvTipiList = iFrame.dataCollector.getKdvTipiList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}