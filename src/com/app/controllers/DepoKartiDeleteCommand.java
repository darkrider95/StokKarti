package com.app.controllers;
import com.app.models.DepoKartiModel;
import com.app.views.DepoKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepoKartiDeleteCommand implements ActionListener {

    private DepoKartiFrame iFrame;
    private DepoKartiSaveCommand saveCommand;
    public DepoKartiDeleteCommand(DepoKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void delete(){
        DepoKartiModel depoKartlari = saveCommand.getFieldData();
        try {
            if(saveCommand.checkInList(depoKartlari) && iFrame.fieldDepoKodu.getText().length() !=0) {
                iFrame.dataCollector.deleteDepoKarti((iFrame.fieldDepoKodu.getText()));
                JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı", "",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Depo Kodu Bulunamadı.", "",JOptionPane.INFORMATION_MESSAGE);
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
