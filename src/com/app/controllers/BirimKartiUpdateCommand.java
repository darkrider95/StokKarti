package com.app.controllers;
import com.app.models.BirimKartiModel;
import com.app.views.BirimKartiFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirimKartiUpdateCommand implements ActionListener {
    private BirimKartiFrame iFrame;
    private BirimKartiSaveCommand saveCommand;
    public BirimKartiUpdateCommand(BirimKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void update(){
        BirimKartiModel birimKartlari = saveCommand.getFieldData();
        iFrame.dataCollector.updateBirimKarti(birimKartlari);
        iFrame.birimKartiList = iFrame.filtredBirimKartiList = iFrame.dataCollector.getBirimKartiList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}