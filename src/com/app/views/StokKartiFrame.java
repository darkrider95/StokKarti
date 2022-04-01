package com.app.views;
import com.app.controllers.*;
import com.app.datacollectors.StokKartiDataCollector;
import com.app.face.BaseInternalFrame;
import com.app.models.StokKartiModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;

import static com.app.views.MenuBar.createMenuBar;

public class StokKartiFrame extends JInternalFrame implements BaseInternalFrame {

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
    private JButton buttonKopyala;
    public JTextField fieldStokAdi;
    public JTextField fieldBarkodu;
    public JDateChooser fieldOlusturmaTarihi;

    public StokKartiDataCollector dataCollector;
    public ArrayList<StokKartiModel> stokKartlariList;
    public ArrayList<StokKartiModel> filtredStokKartlariList;

    public StokKartiFrame()  {

        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Stok Kartı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setJMenuBar(createMenuBar(this));
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();


        StokKartiSearchCommand searchCommand = null;
        buttonAra.addActionListener(searchCommand = new StokKartiSearchCommand(this));

        StokKartiSaveCommand saveCommand = null;
        buttonEkle.addActionListener(saveCommand = new StokKartiSaveCommand(searchCommand));

        StokKartiDeleteCommand deleteCommand = null;
        buttonSil.addActionListener(deleteCommand = new StokKartiDeleteCommand(this));

        StokKartiUpdateCommand updateCommand = null;
        buttonGuncelle.addActionListener(updateCommand = new StokKartiUpdateCommand(saveCommand));

        StokKartiCopyCommand copyCommand = null;
        buttonKopyala.addActionListener(copyCommand = new StokKartiCopyCommand(saveCommand));

        FocusListener focusListener = new FocusListener(fieldStokKodu,fieldStokAdi,this);


        //FillFieldsWhenClicked fillFields = null;
        //tableStokKartlari.addMouseListener((MouseListener) (fillFields = new FillFieldsWhenClicked(this)));
    }

    private void createUIComponents() {
        fieldOlusturmaTarihi = new JDateChooser();
    }

    @Override
    public void setSearchedField(String masterField) {
        Optional<StokKartiModel> optionalBaseDataModel = stokKartlariList.stream().filter(item -> item.getStokKodu().equals(masterField)).findFirst();

        if (optionalBaseDataModel.isPresent())
            fieldStokAdi.setText(optionalBaseDataModel.get().getAdi());
    }
}

