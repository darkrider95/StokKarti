package com.app.controllers;
import com.app.models.DepoKartiModel;
import com.app.views.DepoKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepoKartiCopyCommand implements ActionListener {

    private DepoKartiFrame iFrame;
    private DepoKartiSaveCommand saveCommand;
    public DepoKartiCopyCommand(DepoKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void copy(){

        DepoKartiModel depoKartlari = saveCommand.getFieldData();
        if(checkStokKodu(depoKartlari.getDepoKodu())){
            iFrame.dataCollector.addDepoKarti(depoKartlari);
        }else{
            String value = JOptionPane.showInputDialog(this, "Yeni depo kartı için Depo Kodu girin.");
            if(value != null){
                if(checkStokKodu(value)){
                    depoKartlari.setDepoKodu(value);
                    iFrame.dataCollector.addDepoKarti(depoKartlari);
                }else{
                    JOptionPane.showMessageDialog(null, "Eşsiz bir depo kodu girin.", "",JOptionPane.INFORMATION_MESSAGE);
                    copy();
                }
            }
        }
        iFrame.depoList = iFrame.filtredDepoList = iFrame.dataCollector.getDepoKartlariList();
    }

    public boolean checkStokKodu(String value){
        for(DepoKartiModel depoKartlari : iFrame.depoList){
            if(depoKartlari.getDepoKodu().equals(value))
                return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        copy();
    }
}
