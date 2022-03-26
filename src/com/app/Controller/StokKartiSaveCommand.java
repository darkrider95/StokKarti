package com.app.Controller;
import com.app.Model.StokKartlari;
import com.app.View.StokKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiSaveCommand implements ActionListener {

    public StokKartiFrame iFrame;
    public StokKartiSaveCommand(StokKartiFrame app){
        this.iFrame = app;
    }


    public void add(){
        StokKartlari stokKartlari = getFieldData();
        if(isSuitableToSave()){
            StokKartiDataCollector.addStokKarti(stokKartlari);
            JOptionPane.showMessageDialog(null, "Ekleme işlemi başarılı.", "",JOptionPane.INFORMATION_MESSAGE);
        }
        iFrame.stokKartlariList = iFrame.filtredStokKartlariList = iFrame.dataCollector.getStokKartiList();
    }

    public boolean checkInList(StokKartlari stokKartlari) {
        return iFrame.filtredStokKartlariList.stream().filter(o -> o.getStokKodu().equals(stokKartlari.getStokKodu())).findFirst().isPresent();
    }

    public boolean isSuitableToSave(){
        StokKartlari stokKartlari = getFieldData();
        if(!checkInList(stokKartlari) && iFrame.fieldStokKodu.getText().length() != 0 && iFrame.fieldStokAdi.getText().length() != 0 && iFrame.fieldBarkodu.getText().length() != 0) {
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Zorunlu alanları doldurun ya da eşsiz bir stok kodu girin.", "Hata",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public StokKartlari getFieldData(){
        StokKartlari stokKartlari = new StokKartlari();
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
        StokKartiListCommand.list();
    }
}
