package com.app.views;
import com.app.controllers.StokTipiCopyCommand;
import com.app.controllers.StokTipiDeleteCommand;
import com.app.controllers.StokTipiSaveCommand;
import com.app.controllers.StokTipiUpdateCommand;
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
    public JTextField fieldStokTipiAdi;
    public JTextArea fieldAciklama;
    private JButton buttonEkle;
    private JButton buttonSil;
    public JTextField fieldStokTipiKodu;
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

        StokTipiSaveCommand saveCommand = null;
        buttonEkle.addActionListener(saveCommand = new StokTipiSaveCommand(this));

        StokTipiDeleteCommand deleteCommand = null;
        buttonSil.addActionListener(deleteCommand = new StokTipiDeleteCommand(saveCommand));

        StokTipiUpdateCommand updateCommand = null;
        buttonGuncelle.addActionListener(updateCommand = new StokTipiUpdateCommand(saveCommand));

        StokTipiCopyCommand copyCommand = null;
        buttonKopyala.addActionListener(copyCommand = new StokTipiCopyCommand(saveCommand));

    }
}