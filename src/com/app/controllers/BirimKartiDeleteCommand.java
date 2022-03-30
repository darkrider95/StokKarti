package com.app.controllers;
import com.app.models.BirimKartiModel;
import com.app.views.BirimKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirimKartiDeleteCommand implements ActionListener {

    private BirimKartiFrame iFrame;
    private BirimKartiSaveCommand saveCommand;
    public BirimKartiDeleteCommand(BirimKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void delete(){
        BirimKartiModel birimKartlari = saveCommand.getFieldData();
        try {
            if(saveCommand.checkInList(birimKartlari) && iFrame.fieldBirimKodu.getText().length() !=0) {
                iFrame.dataCollector.deleteBirimKarti((iFrame.fieldBirimKodu.getText()));
                JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı", "",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Birim Kodu Bulunamadı.", "",JOptionPane.INFORMATION_MESSAGE);
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
