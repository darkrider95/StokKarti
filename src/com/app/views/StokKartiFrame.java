package com.app.views;
import com.app.controllers.*;
import com.app.datacollectors.StokKartiDataCollector;
import com.app.face.BaseInternalFrame;
import com.app.models.BaseDataModel;
import com.app.models.StokKartiModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;

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
    private JButton buttonNext;
    private JButton buttonPrevious;
    private JButton buttonLast;
    private JButton buttonFirst;

    public StokKartiDataCollector dataCollector;
    public ArrayList<StokKartiModel> stokKartlariList = dataCollector.getStokKartiList();
    public ArrayList<StokKartiModel> filtredStokKartlariList;
    public ListIterator<StokKartiModel> listIterator = stokKartlariList.listIterator();

    public StokKartiFrame()  {

        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Stok Kartı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();

        StokKartiSaveCommand saveCommand = null;
        buttonEkle.addActionListener(saveCommand = new StokKartiSaveCommand(this));

        StokKartiDeleteCommand deleteCommand = null;
        buttonSil.addActionListener(deleteCommand = new StokKartiDeleteCommand(this));

        StokKartiUpdateCommand updateCommand = null;
        buttonGuncelle.addActionListener(updateCommand = new StokKartiUpdateCommand(saveCommand));

        StokKartiCopyCommand copyCommand = null;
        buttonKopyala.addActionListener(copyCommand = new StokKartiCopyCommand(saveCommand));

        NextCommand nextCommand = null;
        buttonNext.addActionListener(nextCommand = new NextCommand(this));

        PreviousCommand previousCommand = null;
        buttonPrevious.addActionListener(previousCommand = new PreviousCommand(this));

        FocusListener focusListener = new FocusListener(fieldStokKodu,fieldStokAdi,this);

        //FillFieldsWhenClicked fillFields = null;
        //tableStokKartlari.addMouseListener((MouseListener) (fillFields = new FillFieldsWhenClicked(this)));

        LastCommand lastCommand = null;
        buttonLast.addActionListener(lastCommand = new LastCommand(this));

        FisrtCommand fisrtCommand = null;
        buttonFirst.addActionListener(fisrtCommand = new FisrtCommand(this));
    }

    private void createUIComponents() {
        fieldOlusturmaTarihi = new JDateChooser();
    }

    @Override
    public void setSearchedField(BaseDataModel dataModel) {

        Optional<StokKartiModel> optionalBaseDataModel = stokKartlariList.stream().filter(item -> item.getStokKodu().equals(dataModel.getMasterField())).findFirst();
        if (optionalBaseDataModel.isPresent()){
            StokKartiModel stokKartiModel = optionalBaseDataModel.stream().findFirst().get();
            fieldStokKodu.setText(stokKartiModel.getStokKodu());
            fieldStokAdi.setText(optionalBaseDataModel.get().getAdi());
            comboStokTipi.setSelectedIndex(optionalBaseDataModel.get().getStokTipi()-1);
            comboBirimi.setSelectedItem(optionalBaseDataModel.get().getBirimi());
            fieldBarkodu.setText(optionalBaseDataModel.get().getBarkodu());
            comboKdvTipi.setSelectedIndex(optionalBaseDataModel.get().getKdvTipi().intValue()-1);
            fieldAciklama.setText(optionalBaseDataModel.get().getAciklama());
            fieldOlusturmaTarihi.setDate(optionalBaseDataModel.get().getOlusturmaTarihi());
        }
    }

    @Override
    public BaseDataModel prepareNewModel(int type) throws SQLException {
        BaseDataModel dataModel = new BaseDataModel();
        StokKartiModel row = null;

        if(type == 1 ){
           row = new StokKartiDataCollector().MoveInStokKartlari(StokKartiDataCollector.previousQuery, fieldStokKodu.getText()).get(0);

        }if(type == 0){
           row = new StokKartiDataCollector().MoveInStokKartlari(StokKartiDataCollector.nextQuery, fieldStokKodu.getText()).get(0);
        }if (type == 3){
            row = new StokKartiDataCollector().MoveTo(true).get(0);
        }if (type == 2){
            row = new StokKartiDataCollector().MoveTo(false).get(0);
        }


            dataModel.setMasterField(row.getStokKodu());
            dataModel.setAdi(row.getStokAdi());
            dataModel.setTipi(row.getTipi());
            dataModel.setBirimi(row.getBirimi());
            dataModel.setBarkodu(row.getBarkodu());
            dataModel.setKdvTipi(row.getKdvTipi());
            dataModel.setAciklama(row.getAciklama());
            dataModel.setOlusturmaTarihi(row.getOlusturmaTarihi());

        return dataModel;
    }

    @Override
    public BaseDataModel getCurrentDataModel() {
        BaseDataModel dataModel = new BaseDataModel();
        dataModel.setMasterField(fieldStokKodu.getText());
        return dataModel;
    }
}

