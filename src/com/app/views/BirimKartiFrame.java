package com.app.views;
import com.app.datacollectors.BirimKartiDataCollector;
import com.app.models.BirimKartiModel;
import javax.swing.*;
import java.util.ArrayList;

public class BirimKartiFrame extends JInternalFrame{
    public JTable tableBirimKarti;
    private JButton buttonListele;
    private JPanel mainField;
    private JTextField fieldStokAdi;
    private JTextField fieldStokKodu;
    private JTextArea fieldAciklama;
    private JButton buttonEkle;
    private JButton buttonSil;
    private JButton buttonGuncelle;
    private JButton buttonKopyala;
    private JTextField fieldAra;
    private JButton buttonAra;

    public BirimKartiDataCollector dataCollector;
    public ArrayList<BirimKartiModel> birimKartiList;
    public ArrayList<BirimKartiModel> filtredBirimKartiList;

    public BirimKartiFrame() {
        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Birim Kartı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        birimKartiList = filtredBirimKartiList = dataCollector.getBirimKartiList();

    }
}
