package com.app.controllers;
import com.app.models.StokKartiModel;
import com.app.views.StokKartiFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiUpdateCommand implements ActionListener {

    private static StokKartiFrame iFrame;
    private StokKartiSaveCommand saveCommand;
    public StokKartiUpdateCommand(StokKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void update(){
        StokKartiModel stokKartlari = saveCommand.getFieldData();
        iFrame.dataCollector.updateStokKarti(stokKartlari);
        iFrame.stokKartlariList = iFrame.filtredStokKartlariList = iFrame.dataCollector.getStokKartiList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}
