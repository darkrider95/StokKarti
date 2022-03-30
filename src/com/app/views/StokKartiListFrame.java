package com.app.views;
import com.app.Const.Config;
import com.app.datacollectors.StokKartiDataCollector;
import com.app.models.StokKartiModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;


public class StokKartiListFrame  extends JInternalFrame  {

    public JTable tableStokKartlari;
    private JButton button1;
    public DefaultTableModel modelStokKartlari;
    public ArrayList<StokKartiModel> stokKartlariList;
    public ArrayList<StokKartiModel> filtredStokKartlariList;
    public StokKartiDataCollector dataCollector;
    private JPanel mainField;

    public void list() {
        modelStokKartlari = new DefaultTableModel();
        modelStokKartlari.setColumnIdentifiers(Config.COLUMN_STOK_LIST);
        tableStokKartlari.setModel(modelStokKartlari);
        tableStokKartlari.getTableHeader().setReorderingAllowed(false);
        modelStokKartlari.setRowCount(0);
        for (StokKartiModel obj : filtredStokKartlariList) {
            Object[] row = new Object[Config.COLUMN_STOK_LIST.length];
            row[0] = obj.getStokKodu();
            row[1] = obj.getStokAdi();
            row[2] = obj.getStokTipi();
            row[3] = obj.getBirimi();
            row[4] = obj.getBarkodu();
            row[5] = obj.getKdvTipi();
            row[6] = obj.getAciklama();
            row[7] = obj.getOlusturmaTarihi();
            modelStokKartlari.addRow(row);
        }
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();
    }

    public StokKartiListFrame() {
        setContentPane(mainField);
        setSize(1000, 600);
        setTitle("Stok Kart Listesi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list();
            }
        });
    }

}


