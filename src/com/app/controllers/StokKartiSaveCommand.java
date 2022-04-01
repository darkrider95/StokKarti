package com.app.controllers;
import com.app.datacollectors.StokKartiDataCollector;
import com.app.models.StokKartiModel;
import com.app.views.StokKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiSaveCommand implements ActionListener {

    public StokKartiFrame iFrame;
    public StokKartiSearchCommand searchCommand;
    public StokKartiSaveCommand(StokKartiSearchCommand searchCommand){
        this.searchCommand = searchCommand;
        this.iFrame = searchCommand.iFrame;
    }

    public void add(){
        StokKartiModel stokKartlari = getFieldData();
        if(isSuitableToSave()){
            StokKartiDataCollector.addStokKarti(stokKartlari);
            JOptionPane.showMessageDialog(null, "Ekleme işlemi başarılı.", "",JOptionPane.INFORMATION_MESSAGE);
        }
        iFrame.stokKartlariList = iFrame.filtredStokKartlariList = iFrame.dataCollector.getStokKartiList();
    }

    public boolean checkInList(StokKartiModel stokKartlari) {
        return iFrame.filtredStokKartlariList.stream().filter(o -> o.getStokKodu().equals(stokKartlari.getStokKodu())).findFirst().isPresent();
    }

    public boolean isSuitableToSave(){
        StokKartiModel stokKartlari = getFieldData();
        if(!checkInList(stokKartlari) && iFrame.fieldStokKodu.getText().length() != 0 && iFrame.fieldStokAdi.getText().length() != 0 && iFrame.fieldBarkodu.getText().length() != 0) {
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Zorunlu alanları doldurun ya da eşsiz bir stok kodu girin.", "Hata",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public StokKartiModel getFieldData(){
        StokKartiModel stokKartlari = new StokKartiModel();
        stokKartlari.setStokKodu(iFrame.fieldStokKodu.getText());
        stokKartlari.setStokAdi(iFrame.fieldStokAdi.getText());
        stokKartlari.setStokTipi(Integer.valueOf(iFrame.comboStokTipi.getSelectedItem().toString()));
        stokKartlari.setBirimi(iFrame.comboBirimi.getSelectedItem().toString());
        stokKartlari.setBarkodu(iFrame.fieldBarkodu.getText());
        stokKartlari.setKdvTipi(Double.valueOf(iFrame.comboKdvTipi.getSelectedItem().toString()));
        stokKartlari.setAciklama(iFrame.fieldAciklama.getText());
        stokKartlari.setOlusturmaTarihi(iFrame.fieldOlusturmaTarihi.getDate());
        return stokKartlari;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        add();
    }
}
