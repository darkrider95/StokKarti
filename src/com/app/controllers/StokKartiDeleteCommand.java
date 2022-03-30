package com.app.controllers;
import com.app.views.StokKartiFrame;

import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiDeleteCommand implements ActionListener {

    private StokKartiFrame iFrame;
    public StokKartiDeleteCommand(StokKartiFrame iFrame){
        this.iFrame = iFrame;
    }

    public String SelectedRow(){
        TableModel model = iFrame.tableStokKartlari.getModel();
        String value = String.valueOf(model.getValueAt(iFrame.tableStokKartlari.getSelectedRow(),0));
        return value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean result = iFrame.dataCollector.deleteStokKarti(SelectedRow());
        iFrame.stokKartlariList = iFrame.filtredStokKartlariList = iFrame.dataCollector.getStokKartiList();
    }
}
