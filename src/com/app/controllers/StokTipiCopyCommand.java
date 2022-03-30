package com.app.controllers;
import com.app.models.StokTipiModel;
import com.app.views.StokTipiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokTipiCopyCommand implements ActionListener {
    private StokTipiFrame iFrame;
    private StokTipiSaveCommand saveCommand;
    public StokTipiCopyCommand(StokTipiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void copy(){

        StokTipiModel stokTipiKartlari = saveCommand.getFieldData();
        if(checkStokKodu(stokTipiKartlari.getStokTipiKodu())){
            iFrame.dataCollector.addStokTipiKarti(stokTipiKartlari);
        }else{
            String value = JOptionPane.showInputDialog(this, "Yeni stok tipi kartı için Stok Tipi Kodu girin.");
            if(value != null){
                if(checkStokKodu(value)){
                    stokTipiKartlari.setStokTipiKodu(value);
                    iFrame.dataCollector.addStokTipiKarti(stokTipiKartlari);
                }else{
                    JOptionPane.showMessageDialog(null, "Eşsiz bir stok tipi kodu girin.", "",JOptionPane.INFORMATION_MESSAGE);
                    copy();
                }
            }
        }
        iFrame.stokTipiList = iFrame.filtredStokTipiList = iFrame.dataCollector.getStokTipiList();
    }

    public boolean checkStokKodu(String value){
        for(StokTipiModel stokTipiKartlari : iFrame.stokTipiList){
            if(stokTipiKartlari.getStokTipiKodu().equals(value))
                return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        copy();
    }
}

