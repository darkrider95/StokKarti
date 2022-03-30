package com.app.controllers;
import com.app.models.StokTipiModel;
import com.app.views.StokTipiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokTipiDeleteCommand implements ActionListener {
    private StokTipiFrame iFrame;
    private StokTipiSaveCommand saveCommand;
    public StokTipiDeleteCommand(StokTipiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void delete(){
        StokTipiModel stokTipiKartlari = saveCommand.getFieldData();
        try {
            if(saveCommand.checkInList(stokTipiKartlari) && iFrame.fieldStokTipiKodu.getText().length() !=0) {
                iFrame.dataCollector.deleteStokTipiKarti((iFrame.fieldStokTipiKodu.getText()));
                JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı", "",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Stok Tipi Kodu Bulunamadı.", "",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(Exception e)
        {
            System.out.println("Hata! Kart Silinemedi. "+e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        delete();
    }
}