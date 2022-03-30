package com.app.views;
import com.app.controllers.BirimKartiCopyCommand;
import com.app.controllers.BirimKartiDeleteCommand;
import com.app.controllers.BirimKartiSaveCommand;
import com.app.controllers.BirimKartiUpdateCommand;
import com.app.datacollectors.BirimKartiDataCollector;
import com.app.models.BirimKartiModel;
import javax.swing.*;
import java.util.ArrayList;

public class BirimKartiFrame extends JInternalFrame{
    private JButton buttonListele;
    private JPanel mainField;
    public JTextField fieldBirimAdi;
    public JTextField fieldBirimKodu;
    public JTextArea fieldAciklama;
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

        BirimKartiSaveCommand saveCommand = null;
        buttonEkle.addActionListener(saveCommand = new BirimKartiSaveCommand(this));

        BirimKartiDeleteCommand deleteCommand = null;
        buttonSil.addActionListener(deleteCommand = new BirimKartiDeleteCommand(saveCommand));

        BirimKartiUpdateCommand updateCommand = null;
        buttonGuncelle.addActionListener(updateCommand = new BirimKartiUpdateCommand(saveCommand));

        BirimKartiCopyCommand copyCommand = null;
        buttonKopyala.addActionListener(copyCommand = new BirimKartiCopyCommand(saveCommand));


    }
}
