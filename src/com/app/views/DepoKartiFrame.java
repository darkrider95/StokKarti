package com.app.views;
import com.app.controllers.DepoKartiCopyCommand;
import com.app.controllers.DepoKartiDeleteCommand;
import com.app.controllers.DepoKartiSaveCommand;
import com.app.controllers.DepoKartiUpdateCommand;
import com.app.datacollectors.DepoKartiDataCollector;
import com.app.models.DepoKartiModel;
import javax.swing.*;
import java.util.ArrayList;

public class DepoKartiFrame extends JInternalFrame {
    private JPanel mainField;
    public JTextField fieldDepoAdi;
    private JButton buttonAra;
    private JTextField fieldAra;
    private JButton buttonEkle;
    private JButton buttonSil;
    private JButton buttonGuncelle;
    public JTextField fieldDepoKodu;
    private JButton buttonKopyala;
    public JTextArea fieldDepoAciklama;


    public DepoKartiDataCollector dataCollector;
    public ArrayList<DepoKartiModel> depoList;
    public ArrayList<DepoKartiModel> filtredDepoList;

    public DepoKartiFrame() {
        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Depo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        depoList = filtredDepoList = dataCollector.getDepoKartlariList();

        DepoKartiSaveCommand saveCommand = null;
        buttonEkle.addActionListener(saveCommand = new DepoKartiSaveCommand(this));

        DepoKartiDeleteCommand deleteCommand = null;
        buttonSil.addActionListener(deleteCommand = new DepoKartiDeleteCommand(saveCommand));

        DepoKartiUpdateCommand updateCommand = null;
        buttonGuncelle.addActionListener(updateCommand = new DepoKartiUpdateCommand(saveCommand));

        DepoKartiCopyCommand copyCommand = null;
        buttonKopyala.addActionListener(copyCommand = new DepoKartiCopyCommand(saveCommand));

    }
}
