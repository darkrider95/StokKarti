package com.app.controllers;
import com.app.datacollectors.DepoKartiDataCollector;
import com.app.models.DepoKartiModel;
import com.app.views.DepoKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepoKartiSaveCommand implements ActionListener {
    public DepoKartiFrame iFrame;
    public DepoKartiSaveCommand(DepoKartiFrame iFrame){
        this.iFrame = iFrame;
    }

    public void add(){
        DepoKartiModel depoKartlari = getFieldData();
        if(isSuitableToSave()){
            DepoKartiDataCollector.addDepoKarti(depoKartlari);
            JOptionPane.showMessageDialog(null, "Ekleme işlemi başarılı.", "",JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Zorunlu alanları doldurun ya da eşsiz bir stok kodu girin.", "Hata",JOptionPane.INFORMATION_MESSAGE);
        }
        iFrame.depoList = iFrame.filtredDepoList = iFrame.dataCollector.getDepoKartlariList();
    }

    public boolean checkInList(DepoKartiModel depoKartlari){
        return iFrame.filtredDepoList.stream().filter(o -> o.getDepoKodu().equals(depoKartlari.getDepoKodu())).findFirst().isPresent();
    }

    public boolean isSuitableToSave(){
        DepoKartiModel depoKartlari = getFieldData();
        if(!checkInList(depoKartlari) && iFrame.fieldDepoKodu.getText().length() !=0 && iFrame.fieldDepoAdi.getText().length() !=0){
            return true;
        }
        return false;
    }

    public DepoKartiModel getFieldData(){
        DepoKartiModel depoKartlari = new DepoKartiModel();
        depoKartlari.setDepoKodu(iFrame.fieldDepoKodu.getText());
        depoKartlari.setDepoAdi(iFrame.fieldDepoAdi.getText());
        depoKartlari.setDepoAciklama(iFrame.fieldDepoAciklama.getText());
        return depoKartlari;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        add();
    }
}
