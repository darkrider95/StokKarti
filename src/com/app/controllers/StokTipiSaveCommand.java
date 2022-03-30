package com.app.controllers;
import com.app.datacollectors.StokTipiDataCollector;
import com.app.models.StokTipiModel;
import com.app.views.StokTipiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokTipiSaveCommand implements ActionListener {
    public StokTipiFrame iFrame;
    public StokTipiSaveCommand(StokTipiFrame iFrame){
        this.iFrame = iFrame;
    }

    public void add(){
        StokTipiModel stokTipiKartlari = getFieldData();
        if(isSuitableToSave()){
            StokTipiDataCollector.addStokTipiKarti(stokTipiKartlari);
            JOptionPane.showMessageDialog(null, "Ekleme işlemi başarılı.", "",JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Zorunlu alanları doldurun ya da eşsiz bir stok tipi kodu girin.", "Hata",JOptionPane.INFORMATION_MESSAGE);
        }
        iFrame.stokTipiList = iFrame.filtredStokTipiList = iFrame.dataCollector.getStokTipiList();
    }

    public boolean checkInList(StokTipiModel  stokTipiKartlari){
        return iFrame.filtredStokTipiList.stream().filter(o -> o.getStokTipiKodu().equals(stokTipiKartlari.getStokTipiKodu())).findFirst().isPresent();
    }

    public boolean isSuitableToSave(){
        StokTipiModel stokTipiKartlari = getFieldData();
        if(!checkInList(stokTipiKartlari) && iFrame.fieldStokTipiKodu.getText().length() !=0 && iFrame.fieldStokTipiAdi.getText().length() !=0){
            return true;
        }
        return false;
    }

    public StokTipiModel getFieldData(){
        StokTipiModel stokTipiKarlari = new StokTipiModel();
        stokTipiKarlari.setStokTipiKodu(iFrame.fieldStokTipiKodu.getText());
        stokTipiKarlari.setStokTipiAdi(iFrame.fieldStokTipiAdi.getText());
        stokTipiKarlari.setStokTipiAciklama(iFrame.fieldAciklama.getText());
        return stokTipiKarlari;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        add();
    }
}