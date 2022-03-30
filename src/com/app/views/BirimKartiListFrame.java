package com.app.views;
import com.app.Const.Config;
import com.app.datacollectors.BirimKartiDataCollector;
import com.app.models.BirimKartiModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BirimKartiListFrame extends JInternalFrame{
    private JButton button1;
    private JTable tableBirimKartlari;
    private JPanel mainField;

    public DefaultTableModel modelBirimKartlari;
    public ArrayList<BirimKartiModel> birimKartlariList;
    public ArrayList<BirimKartiModel> filteredBirimKartlariList;
    public BirimKartiDataCollector dataCollector;

    public void list(){
        modelBirimKartlari = new DefaultTableModel();
        modelBirimKartlari.setColumnIdentifiers(Config.COLUMN_BIRIM_LIST);
        tableBirimKartlari.setModel(modelBirimKartlari);
        tableBirimKartlari.getTableHeader().setReorderingAllowed(false);
        modelBirimKartlari.setRowCount(0);
        for (BirimKartiModel obj : filteredBirimKartlariList){
            Object[] row = new Object[Config.COLUMN_BIRIM_LIST.length];
            row[0] = obj.getBirimKartiKodu();
            row[1] = obj.getBirimKartiAdi();
            row[2] = obj.getBirimKartiAciklama();
            modelBirimKartlari.addRow(row);
        }
        birimKartlariList = filteredBirimKartlariList = dataCollector.getBirimKartiList();
    }

    public BirimKartiListFrame() {
        setContentPane(mainField);
        setSize(1000, 600);
        setTitle("Birim Kart Listesi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        birimKartlariList = filteredBirimKartlariList = dataCollector.getBirimKartiList();

        button1.addActionListener(e -> list());
    }
}
