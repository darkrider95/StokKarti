package com.app.views;
import com.app.datacollectors.KdvTipiDataCollector;
import com.app.models.KdvTipiModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class KdvTipiFrame extends JInternalFrame {
    public JTable tableKdvTipi;
    private JButton buttonListele;
    private JPanel mainField;

    public KdvTipiDataCollector dataCollector;
    public ArrayList<KdvTipiModel> kdvTipiList;
    public ArrayList<KdvTipiModel> filtredKdvTipiList;
    private JTextField fieldStokAdi;
    private JTextField fieldStokKodu;
    private JTextArea fieldAciklama;
    private JButton buttonEkle;
    private JButton buttonSil;
    private JButton buttonGuncelle;
    private JButton buttonKopyala;
    private JTextField fieldAra;
    private JButton buttonAra;

    public KdvTipiFrame() {
        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Kdv Tipi Kartı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kdvTipiList = filtredKdvTipiList = dataCollector.getKdvTipiList();

    }
}
