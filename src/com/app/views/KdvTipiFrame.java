package com.app.views;
import com.app.controllers.KdvTipiCopyCommand;
import com.app.controllers.KdvTipiDeleteCommand;
import com.app.controllers.KdvTipiSaveCommand;
import com.app.controllers.KdvTipiUpdateCommand;
import com.app.datacollectors.KdvTipiDataCollector;
import com.app.models.KdvTipiModel;
import javax.swing.*;
import java.util.ArrayList;

public class KdvTipiFrame extends JInternalFrame {

    private JPanel mainField;
    public KdvTipiDataCollector dataCollector;
    public ArrayList<KdvTipiModel> kdvTipiList;
    public ArrayList<KdvTipiModel> filtredKdvTipiList;
    public JTextField fieldKdvTipiAdi;
    public JTextField fieldKdvTipiKodu;
    public JTextArea fieldAciklama;
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

        KdvTipiSaveCommand saveCommand = null;
        buttonEkle.addActionListener(saveCommand = new KdvTipiSaveCommand(this));

        KdvTipiDeleteCommand deleteCommand = null;
        buttonSil.addActionListener(deleteCommand = new KdvTipiDeleteCommand(saveCommand));

        KdvTipiUpdateCommand updateCommand = null;
        buttonGuncelle.addActionListener(updateCommand = new KdvTipiUpdateCommand(saveCommand));

        KdvTipiCopyCommand copyCommand = null;
        buttonKopyala.addActionListener(copyCommand = new KdvTipiCopyCommand(saveCommand));

    }
}
