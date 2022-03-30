package com.app.controllers;
import com.app.models.BirimKartiModel;
import com.app.views.BirimKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirimKartiCopyCommand implements ActionListener {
    private BirimKartiFrame iFrame;
    private BirimKartiSaveCommand saveCommand;
    public BirimKartiCopyCommand(BirimKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void copy(){

        BirimKartiModel birimKartlari = saveCommand.getFieldData();
        if(checkStokKodu(birimKartlari.getBirimKartiKodu())){
            iFrame.dataCollector.addBirimKarti(birimKartlari);
        }else{
            String value = JOptionPane.showInputDialog(this, "Yeni birim kartı için Birim Kodu girin.");
            if(value != null){
                if(checkStokKodu(value)){
                    birimKartlari.setBirimKartiKodu(value);
                    iFrame.dataCollector.addBirimKarti(birimKartlari);
                }else{
                    JOptionPane.showMessageDialog(null, "Eşsiz bir birim kodu girin.", "",JOptionPane.INFORMATION_MESSAGE);
                    copy();
                }
            }
        }
        iFrame.birimKartiList = iFrame.filtredBirimKartiList = iFrame.dataCollector.getBirimKartiList();
    }

    public boolean checkStokKodu(String value){
        for(BirimKartiModel birimKartlari : iFrame.birimKartiList){
            if(birimKartlari.getBirimKartiKodu().equals(value))
                return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        copy();
    }
}