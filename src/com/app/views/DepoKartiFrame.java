package com.app.views;
import com.app.datacollectors.DepoKartiDataCollector;
import com.app.models.DepoKartiModel;
import javax.swing.*;
import java.util.ArrayList;

public class DepoKartiFrame extends JInternalFrame {
    public JTable tableDepo;
    private JPanel mainField;
    private JTextField fieldStokAdi;
    private JButton buttonAra;
    private JTextField fieldAra;
    private JButton buttonEkle;
    private JButton buttonSil;
    private JButton buttonGuncelle;
    private JTextField fieldStokKodu;
    private JTextArea fieldAciklama;
    private JButton buttonKopyala;

    public DepoKartiDataCollector dataCollector;
    public ArrayList<DepoKartiModel> depoList;
    public ArrayList<DepoKartiModel> filtredDepoList;

    public DepoKartiFrame() {
        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Depo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        depoList = filtredDepoList = dataCollector.getDepoKartlariList();

    }
}
