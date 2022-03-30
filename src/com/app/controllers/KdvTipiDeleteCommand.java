package com.app.controllers;
import com.app.models.KdvTipiModel;
import com.app.views.KdvTipiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KdvTipiDeleteCommand implements ActionListener {
    private KdvTipiFrame iFrame;
    private KdvTipiSaveCommand saveCommand;
    public KdvTipiDeleteCommand(KdvTipiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void delete(){
        KdvTipiModel kdvTipiKartlari = saveCommand.getFieldData();
        try {
            if(saveCommand.checkInList(kdvTipiKartlari) && iFrame.fieldKdvTipiKodu.getText().length() !=0) {
                iFrame.dataCollector.deleteKdvTipiKarti((iFrame.fieldKdvTipiKodu.getText()));
                JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı", "",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Kdv Tipi Kodu Bulunamadı.", "",JOptionPane.INFORMATION_MESSAGE);
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