package com.app.views;
import com.app.Const.Config;
import com.app.datacollectors.KdvTipiDataCollector;
import com.app.models.KdvTipiModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class KdvTipiListFrame extends JInternalFrame{
    private JButton button1;
    private JTable tableKdvTipi;
    private JPanel mainField;

    public DefaultTableModel modelKdvTipi;
    public ArrayList<KdvTipiModel> kdvTipiList;
    public ArrayList<KdvTipiModel> filterenKdvTipiList;
    public KdvTipiDataCollector dataCollector;

    public void list(){
        modelKdvTipi = new DefaultTableModel();
        modelKdvTipi.setColumnIdentifiers(Config.COLUMN_KDV_LIST);
        tableKdvTipi.setModel(modelKdvTipi);
        tableKdvTipi.getTableHeader().setReorderingAllowed(false);
        modelKdvTipi.setRowCount(0);
        for (KdvTipiModel obj : filterenKdvTipiList){
            Object[] row = new Object[Config.COLUMN_KDV_LIST.length];
            row[0] = obj.getKdvTipiKodu();
            row[1] = obj.getKdvTipiAdi();
            row[2] = obj.getKdvTipiAciklama();
            modelKdvTipi.addRow(row);
        }
        kdvTipiList = filterenKdvTipiList = dataCollector.getKdvTipiList();
    }

    public KdvTipiListFrame(){
        setContentPane(mainField);
        setSize(1000, 600);
        setTitle("Kdv Tipi Listesi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kdvTipiList = filterenKdvTipiList = dataCollector.getKdvTipiList();

        button1.addActionListener(e -> list());
    }
}
