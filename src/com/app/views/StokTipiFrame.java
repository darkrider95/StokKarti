package com.app.views;
import com.app.datacollectors.StokTipiDataCollector;
import com.app.models.StokTipiModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StokTipiFrame extends JInternalFrame{
    public JTable tableStokTipi;
    private JButton buttonListele;
    private JPanel mainField;

    public DefaultTableModel modelStokTipi;
    public StokTipiDataCollector dataCollector;
    public ArrayList<StokTipiModel> stokTipiList;
    public ArrayList<StokTipiModel> filtredStokTipiList;
    private JTextField fieldStokAdi;
    private JTextArea fieldAciklama;
    private JButton buttonEkle;
    private JButton buttonSil;
    private JTextField fieldStokKodu;
    private JButton buttonGuncelle;
    private JButton buttonKopyala;
    private JTextField fieldAra;
    private JButton buttonAra;

    public StokTipiFrame() {
        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Stok Tipi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stokTipiList = filtredStokTipiList = dataCollector.getStokTipiList();

    }
}