package com.app.controllers;
import com.app.models.DepoKartiModel;
import com.app.views.DepoKartiFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepoKartiUpdateCommand implements ActionListener {

    private DepoKartiFrame iFrame;
    private DepoKartiSaveCommand saveCommand;
    public DepoKartiUpdateCommand(DepoKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void update(){
        DepoKartiModel depoKartlari = saveCommand.getFieldData();
        iFrame.dataCollector.updateDepoKarti(depoKartlari);
        iFrame.depoList = iFrame.filtredDepoList = iFrame.dataCollector.getDepoKartlariList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}
