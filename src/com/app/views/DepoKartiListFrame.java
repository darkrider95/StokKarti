package com.app.views;
import com.app.Const.Config;
import com.app.datacollectors.DepoKartiDataCollector;
import com.app.models.DepoKartiModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DepoKartiListFrame extends JInternalFrame {
    private JButton button1;
    private JTable tableDepoKartlari;
    private JPanel mainField;

    public DefaultTableModel modelDepoKartlari;
    public ArrayList<DepoKartiModel> depoKartlariList;
    public ArrayList<DepoKartiModel> filteredDepoKartlariList;
    public DepoKartiDataCollector dataCollector;

    public void list(){
        modelDepoKartlari = new DefaultTableModel();
        modelDepoKartlari.setColumnIdentifiers(Config.COLUMN_DEPO_LIST);
        tableDepoKartlari.setModel(modelDepoKartlari);
        tableDepoKartlari.getTableHeader().setReorderingAllowed(false);
        modelDepoKartlari.setRowCount(0);
        for (DepoKartiModel obj : filteredDepoKartlariList){
            Object[] row = new Object[Config.COLUMN_DEPO_LIST.length];
            row[0] = obj.getDepoKodu();
            row[1] = obj.getDepoAdi();
            row[2] = obj.getDepoAciklama();
            modelDepoKartlari.addRow(row);
        }
        depoKartlariList = filteredDepoKartlariList = dataCollector.getDepoKartlariList();
    }

    public DepoKartiListFrame() {
        setContentPane(mainField);
        setSize(1000, 600);
        setTitle("Depo Kart Listesi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        depoKartlariList = filteredDepoKartlariList = dataCollector.getDepoKartlariList();

        button1.addActionListener(e -> list());
    }
}
