package com.app.controllers;
import com.app.models.KdvTipiModel;
import com.app.views.KdvTipiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KdvTipiCopyCommand implements ActionListener {

    private KdvTipiFrame iFrame;
    private KdvTipiSaveCommand saveCommand;
    public KdvTipiCopyCommand(KdvTipiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void copy(){

        KdvTipiModel kdvTipiKartlari = saveCommand.getFieldData();
        if(checkStokKodu(kdvTipiKartlari.getKdvTipiKodu())){
            iFrame.dataCollector.addKdvTipiKarti(kdvTipiKartlari);
        }else{
            String value = JOptionPane.showInputDialog(this, "Yeni kdv tipi kartı için Kdv Tipi Kodu girin.");
            if(value != null){
                if(checkStokKodu(value)){
                    kdvTipiKartlari.setKdvTipiKodu(value);
                    iFrame.dataCollector.addKdvTipiKarti(kdvTipiKartlari);
                }else{
                    JOptionPane.showMessageDialog(null, "Eşsiz bir kdv tipi kodu girin.", "",JOptionPane.INFORMATION_MESSAGE);
                    copy();
                }
            }
        }
        iFrame.kdvTipiList = iFrame.filtredKdvTipiList = iFrame.dataCollector.getKdvTipiList();
    }

    public boolean checkStokKodu(String value){
        for(KdvTipiModel kdvTipiKartlari : iFrame.kdvTipiList){
            if(kdvTipiKartlari.getKdvTipiKodu().equals(value))
                return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        copy();
    }
}