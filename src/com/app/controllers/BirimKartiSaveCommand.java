package com.app.controllers;
import com.app.datacollectors.BirimKartiDataCollector;
import com.app.models.BirimKartiModel;
import com.app.views.BirimKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirimKartiSaveCommand implements ActionListener {
    public BirimKartiFrame iFrame;
    public BirimKartiSaveCommand(BirimKartiFrame iFrame){
        this.iFrame = iFrame;
    }

    public void add(){
        BirimKartiModel birimKartlari = getFieldData();
        if(isSuitableToSave()){
            BirimKartiDataCollector.addBirimKarti(birimKartlari);
            JOptionPane.showMessageDialog(null, "Ekleme işlemi başarılı.", "",JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Zorunlu alanları doldurun ya da eşsiz bir birim kodu girin.", "Hata",JOptionPane.INFORMATION_MESSAGE);
        }
        iFrame.birimKartiList = iFrame.filtredBirimKartiList = iFrame.dataCollector.getBirimKartiList();
    }

    public boolean checkInList(BirimKartiModel birimKartlari){
        return iFrame.filtredBirimKartiList.stream().filter(o -> o.getBirimKartiKodu().equals(birimKartlari.getBirimKartiKodu())).findFirst().isPresent();
    }

    public boolean isSuitableToSave(){
        BirimKartiModel birimKartlari = getFieldData();
        if(!checkInList(birimKartlari) && iFrame.fieldBirimKodu.getText().length() !=0 && iFrame.fieldBirimAdi.getText().length() !=0){
            return true;
        }
        return false;
    }

    public BirimKartiModel getFieldData(){
        BirimKartiModel birimKartlari = new BirimKartiModel();
        birimKartlari.setBirimKartiKodu(iFrame.fieldBirimKodu.getText());
        birimKartlari.setBirimKartiAdi(iFrame.fieldBirimAdi.getText());
        birimKartlari.setBirimKartiAciklama(iFrame.fieldAciklama.getText());
        return birimKartlari;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        add();
    }
}