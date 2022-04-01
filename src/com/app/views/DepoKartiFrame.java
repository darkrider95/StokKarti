package com.app.views;
import com.app.controllers.*;
import com.app.datacollectors.DepoKartiDataCollector;
import com.app.face.BaseInternalFrame;
import com.app.models.BaseDataModel;
import com.app.models.DepoKartiModel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;

public class DepoKartiFrame extends JInternalFrame implements BaseInternalFrame {
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
    private JButton buttonPrevious;
    private JButton buttonNext;


    public DepoKartiDataCollector dataCollector;
    public ArrayList<DepoKartiModel> depoList = dataCollector.getDepoKartlariList();
    public ArrayList<DepoKartiModel> filtredDepoList;
    public ListIterator<DepoKartiModel> listIterator = depoList.listIterator();

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

        NextCommand nextCommand = null;
        buttonNext.addActionListener(nextCommand = new NextCommand(this));

        PreviousCommand previousCommand = null;
        buttonPrevious.addActionListener(previousCommand = new PreviousCommand(this));

        FocusListener focusListener = new FocusListener(fieldDepoKodu,fieldDepoAdi,this);

    }


    @Override
    public void setSearchedField(BaseDataModel dataModel) {

        Optional<DepoKartiModel> optionalBaseDataModel = depoList.stream().filter(item -> item.getDepoKodu().equals(dataModel.getMasterField())).findFirst();
        if (optionalBaseDataModel.isPresent()){
            DepoKartiModel depoKartiModel = optionalBaseDataModel.stream().findFirst().get();
            fieldDepoKodu.setText(depoKartiModel.getDepoKodu());
            fieldDepoAdi.setText(optionalBaseDataModel.get().getAdi());
            fieldDepoAciklama.setText(optionalBaseDataModel.get().getDepoAciklama());
        }
    }

    @Override
    public BaseDataModel prepareNewModel(int type) {
        BaseDataModel dataModel = new BaseDataModel();
        DepoKartiModel row = null;

        if(type == 0 && listIterator.hasNext()){
            row = listIterator.next();

        }if(type == 1 && listIterator.hasPrevious()){
            row = listIterator.previous();
        }
        if(row!=null || type == 2){
            dataModel.setMasterField(row.getDepoKodu());
            dataModel.setAdi(row.getDepoAdi());
            dataModel.setAciklama(row.getAciklama());
        }
        return dataModel;
    }


    @Override
    public BaseDataModel getCurrentDataModel() {
        BaseDataModel dataModel = new BaseDataModel();
        dataModel.setMasterField(fieldDepoKodu.getText());
        return dataModel;
    }
}
