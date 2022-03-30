package com.app.controllers;
import com.app.datacollectors.KdvTipiDataCollector;
import com.app.models.KdvTipiModel;
import com.app.views.KdvTipiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KdvTipiSaveCommand implements ActionListener {
    public KdvTipiFrame iFrame;
    public KdvTipiSaveCommand(KdvTipiFrame iFrame){
        this.iFrame = iFrame;
    }

    public void add(){
        KdvTipiModel kdvTipiKartlari = getFieldData();
        if(isSuitableToSave()){
            KdvTipiDataCollector.addKdvTipiKarti(kdvTipiKartlari);
            JOptionPane.showMessageDialog(null, "Ekleme işlemi başarılı.", "",JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Zorunlu alanları doldurun ya da eşsiz bir stok kodu girin.", "Hata",JOptionPane.INFORMATION_MESSAGE);
        }
        iFrame.kdvTipiList = iFrame.filtredKdvTipiList = iFrame.dataCollector.getKdvTipiList();
    }

    public boolean checkInList(KdvTipiModel kdvTipiKartlari){
        return iFrame.filtredKdvTipiList.stream().filter(o -> o.getKdvTipiKodu().equals(kdvTipiKartlari.getKdvTipiKodu())).findFirst().isPresent();
    }

    public boolean isSuitableToSave(){
        KdvTipiModel kdvTipiKartlari = getFieldData();
        if(!checkInList(kdvTipiKartlari) && iFrame.fieldKdvTipiKodu.getText().length() !=0 && iFrame.fieldKdvTipiAdi.getText().length() !=0){
            return true;
        }
        return false;
    }

    public KdvTipiModel getFieldData(){
        KdvTipiModel kdvTipiKartlari = new KdvTipiModel();
        kdvTipiKartlari.setKdvTipiKodu(iFrame.fieldKdvTipiKodu.getText());
        kdvTipiKartlari.setKdvTipiAdi(iFrame.fieldKdvTipiAdi.getText());
        kdvTipiKartlari.setKdvTipiAciklama(iFrame.fieldAciklama.getText());
        return kdvTipiKartlari;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        add();
    }
}