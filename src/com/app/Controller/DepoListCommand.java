package com.app.Controller;

import com.app.Const.Config;
import com.app.Model.DepoModel;
import com.app.View.Depo;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepoListCommand implements ActionListener {

    private static Depo depo;
    public DepoListCommand(Depo depo){
        this.depo = depo;
    }

    public static void list(){
        depo.modelDepo = new DefaultTableModel();
        depo.modelDepo.setColumnIdentifiers(Config.COLUMN_DEPO_LIST);
        depo.tableDepo.setModel(depo.modelDepo);
        depo.tableDepo.getTableHeader().setReorderingAllowed(false);
        depo.modelDepo.setRowCount(0);
        for (DepoModel obj : depo.filtredDepoList){
            Object[] row = new Object[Config.COLUMN_DEPO_LIST.length];
            row[0] = obj.getDepoKodu();
            row[1] = obj.getDepoAdi();
            row[2] = obj.getDepoAciklama();
            depo.modelDepo.addRow(row);
        }
        depo.depoList = depo.filtredDepoList = depo.dataCollector.getDepoList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        list();
    }
}
