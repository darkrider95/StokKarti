package com.app.Controller;
import com.app.Model.StokKartlari;
import com.app.View.App;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiSaveCommand implements ActionListener {

    private static App app;
    public StokKartiSaveCommand(App app){
        this.app = app;
    }

    public void add(){
        StokKartlari stokKartlari = getFieldData();
        if(isSuitableToSave()){
            DataCollector.addStokKarti(stokKartlari);
            JOptionPane.showMessageDialog(null, "Ekleme işlemi başarılı.", "",JOptionPane.INFORMATION_MESSAGE);
        }
        app.stokKartlariList = app.filtredStokKartlariList = app.dataCollector.getStokKartiList();
    }

    public boolean checkInList(StokKartlari stokKartlari) {
        return app.filtredStokKartlariList.stream().filter(o -> o.getStokKodu().equals(stokKartlari.getStokKodu())).findFirst().isPresent();
    }

    public boolean isSuitableToSave(){
        StokKartlari stokKartlari = getFieldData();
        if(!checkInList(stokKartlari) && app.fieldStokKodu.getText().length() != 0 && app.fieldStokAdi.getText().length() != 0 && app.fieldBarkodu.getText().length() != 0) {
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Zorunlu alanları doldurun ya da eşsiz bir stok kodu girin.", "Hata",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public static StokKartlari getFieldData(){
        StokKartlari stokKartlari = new StokKartlari();
        stokKartlari.setStokKodu(app.fieldStokKodu.getText());
        stokKartlari.setStokAdi(app.fieldStokAdi.getText());
        stokKartlari.setStokTipi(Integer.valueOf(app.comboStokTipi.getSelectedItem().toString()));
        stokKartlari.setBirimi(app.comboBirimi.getSelectedItem().toString());
        stokKartlari.setBarkodu(app.fieldBarkodu.getText());
        stokKartlari.setKdvTipi(Double.valueOf(app.comboKdvTipi.getSelectedItem().toString()));
        stokKartlari.setAciklama(app.fieldAciklama.getText());
        stokKartlari.setOlusturmaTarihi(app.fieldOlusturmaTarihi.getDate());
        return stokKartlari;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        add();
        StokKartiListCommand.list();
    }
}
