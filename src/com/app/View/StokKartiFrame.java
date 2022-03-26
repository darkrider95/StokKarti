package com.app.View;
import com.app.Controller.*;
import com.app.Model.StokKartlari;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import static com.app.View.MenuBar.createMenuBar;

public class StokKartiFrame extends JInternalFrame {

    private JButton buttonEkle;
    private JButton buttonAra;
    private JButton buttonSil;
    private JButton buttonGuncelle;
    public JTextField fieldStokKodu;
    public JComboBox comboStokTipi;
    public JComboBox comboBirimi;
    public JComboBox comboKdvTipi;
    public JTextArea fieldAciklama;
    public JTextField fieldAra;
    private JPanel mainField;
    public JTable tableStokKartlari;
    private JScrollPane scrollStokKartlari;
    private JButton buttonListele;
    private JButton buttonKopyala;
    public JTextField fieldStokAdi;
    public JTextField fieldBarkodu;
    public JDateChooser fieldOlusturmaTarihi;

    public DefaultTableModel modelStokKartlari;
    public StokKartiDataCollector dataCollector;
    public ArrayList<StokKartlari> stokKartlariList;
    public ArrayList<StokKartlari> filtredStokKartlariList;

    public StokKartiFrame()  {

        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Stok Kartı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setJMenuBar(createMenuBar(this));
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();

        StokKartiListCommand listCommand = null;
        buttonListele.addActionListener(listCommand = new StokKartiListCommand(this));

        StokKartiSaveCommand saveCommand = null;
        buttonEkle.addActionListener(saveCommand = new StokKartiSaveCommand(this));

        StokKartiSearchCommand searchCommand = null;
        buttonAra.addActionListener(searchCommand = new StokKartiSearchCommand(this));

        StokKartiDeleteCommand deleteCommand = null;
        buttonSil.addActionListener(deleteCommand = new StokKartiDeleteCommand(this));

        StokKartiUpdateCommand updateCommand = null;
        buttonGuncelle.addActionListener(updateCommand = new StokKartiUpdateCommand(this));

        StokKartiCopyCommand copyCommand = null;
        buttonKopyala.addActionListener(copyCommand = new StokKartiCopyCommand(saveCommand));

        FillFieldsWhenClicked fillFields = null;
        tableStokKartlari.addMouseListener((MouseListener) (fillFields = new FillFieldsWhenClicked(this)));
    }

    private void createUIComponents() {
        fieldOlusturmaTarihi = new JDateChooser();
    }
}

