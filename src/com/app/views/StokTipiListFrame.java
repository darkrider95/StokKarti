package com.app.views;

import com.app.Const.Config;
import com.app.datacollectors.KdvTipiDataCollector;
import com.app.datacollectors.StokTipiDataCollector;
import com.app.models.KdvTipiModel;
import com.app.models.StokTipiModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StokTipiListFrame extends JInternalFrame {
    private JButton button1;
    private JTable tableStokTipiList;
    private JPanel mainField;

    public DefaultTableModel modelStokTipi;
    public ArrayList<StokTipiModel> stokTipiList;
    public ArrayList<StokTipiModel> filteredStokTipiList;
    public StokTipiDataCollector dataCollector;

    public void list(){
        modelStokTipi = new DefaultTableModel();
        modelStokTipi.setColumnIdentifiers(Config.COLUMN_STOK_TIPI_LIST);
        tableStokTipiList.setModel(modelStokTipi);
        tableStokTipiList.getTableHeader().setReorderingAllowed(false);
        modelStokTipi.setRowCount(0);
        for (StokTipiModel obj : filteredStokTipiList){
            Object[] row = new Object[Config.COLUMN_STOK_TIPI_LIST.length];
            row[0] = obj.getStokTipiKodu();
            row[1] = obj.getStokTipiAdi();
            row[2] = obj.getStokTipiAciklama();
            modelStokTipi.addRow(row);
        }
        stokTipiList = filteredStokTipiList = dataCollector.getStokTipiList();
    }

    public StokTipiListFrame(){
        setContentPane(mainField);
        setSize(1000, 600);
        setTitle("Stok Tipi Listesi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stokTipiList = filteredStokTipiList = dataCollector.getStokTipiList();

        button1.addActionListener(e -> list());
    }
}
