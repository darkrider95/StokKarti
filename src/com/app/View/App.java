package com.app.View;
import com.app.Helper.DataCollector;
import com.app.Model.StokKartlari;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.app.Const.Config.COLUMN_STOK_LIST;

public class App extends JFrame {

    private JButton buttonEkle;
    private JButton buttonAra;
    private JButton buttonSil;
    private JButton buttonGuncelle;
    private JTextField fieldStokKodu;
    private JComboBox comboStokTipi;
    private JComboBox comboBirimi;
    private JComboBox comboKdvTipi;
    private JTextArea fieldAciklama;
    private JTextField fieldAra;

    private JPanel mainField;
    public JTable tableStokKartlari;
    private JScrollPane scrollStokKartlari;
    private JButton buttonListele;
    private JButton buttonKopyala;
    private JTextField fieldStokAdi;
    private JTextField fieldBarkodu;
    private JDateChooser fieldOlusturmaTarihi;

    private DefaultTableModel modelStokKartlari;

    private DataCollector dataCollector;

    private ArrayList<StokKartlari> stokKartlariList;
    private ArrayList<StokKartlari> filtredStokKartlariList;




    public void List(){
        
        modelStokKartlari = new DefaultTableModel();
        modelStokKartlari.setColumnIdentifiers(COLUMN_STOK_LIST);
        tableStokKartlari.setModel(modelStokKartlari);
        tableStokKartlari.getTableHeader().setReorderingAllowed(false);
        modelStokKartlari.setRowCount(0);
            for (StokKartlari obj : filtredStokKartlariList){
                Object[] row = new Object[COLUMN_STOK_LIST.length];
                row[0] = obj.getStokKodu();
                row[1] = obj.getStokAdi();
                row[2] = obj.getStokTipi();
                row[3] = obj.getBirimi();
                row[4] = obj.getBarkodu();
                row[5] = obj.getKdvTipi();
                row[6] = obj.getAciklama();
                row[7] = obj.getOlusturmaTarihi();
                modelStokKartlari.addRow(row);
            }
    }


    public void Add(){
        StokKartlari stokKartlari = new StokKartlari();
        stokKartlari.setStokKodu(fieldStokKodu.getText());
        stokKartlari.setStokAdi(fieldStokAdi.getText());
        stokKartlari.setStokTipi(Integer.valueOf(comboStokTipi.getSelectedItem().toString()));
        stokKartlari.setBirimi(comboBirimi.getSelectedItem().toString());
        stokKartlari.setBarkodu(fieldBarkodu.getText());
        stokKartlari.setKdvTipi(Double.valueOf(comboKdvTipi.getSelectedItem().toString()));
        stokKartlari.setAciklama(fieldAciklama.getText());
        stokKartlari.setOlusturmaTarihi(fieldOlusturmaTarihi.getDate());
        if(!checkInList(stokKartlari) && fieldStokKodu.getText().length() != 0 && fieldStokAdi.getText().length() != 0 ) {
            DataCollector.addStokKarti(stokKartlari);
            JOptionPane.showMessageDialog(null, "Ekleme işlemi başarılı.", "",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Zorunlu alanları doldurun ya da geçerli bir stok kodu girin.", "Hata",JOptionPane.INFORMATION_MESSAGE);
        }

        //listemi güncelliyorum.
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();
    }

    public void Copy(){
        StokKartlari stokKartlari = new StokKartlari();
        stokKartlari.setStokKodu(fieldStokKodu.getText());
        stokKartlari.setStokAdi(fieldStokAdi.getText());
        stokKartlari.setStokTipi(Integer.valueOf(comboStokTipi.getSelectedItem().toString()));
        stokKartlari.setBirimi(comboBirimi.getSelectedItem().toString());
        stokKartlari.setBarkodu(fieldBarkodu.getText());
        stokKartlari.setKdvTipi(Double.valueOf(comboKdvTipi.getSelectedItem().toString()));
        stokKartlari.setAciklama(fieldAciklama.getText());
        stokKartlari.setOlusturmaTarihi(fieldOlusturmaTarihi.getDate());
        dataCollector.copyStokKarti(stokKartlari);


        //listemi güncelliyorum.
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();
    }

    public void Update(){
        StokKartlari stokKartlari = new StokKartlari();
        stokKartlari.setStokKodu(fieldStokKodu.getText());
        stokKartlari.setStokAdi(fieldStokAdi.getText());
        stokKartlari.setStokTipi(Integer.valueOf(comboStokTipi.getSelectedItem().toString()));
        stokKartlari.setBirimi(comboBirimi.getSelectedItem().toString());
        stokKartlari.setBarkodu(fieldBarkodu.getText());
        stokKartlari.setKdvTipi(Double.valueOf(comboKdvTipi.getSelectedItem().toString()));
        stokKartlari.setAciklama(fieldAciklama.getText());
        stokKartlari.setOlusturmaTarihi(fieldOlusturmaTarihi.getDate());
        dataCollector.updateStokKarti(stokKartlari);

        //listemi güncelliyorum.
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();
    }

    private boolean checkInList(StokKartlari stokKartlari) {
        return filtredStokKartlariList.stream().filter(o -> o.getStokKodu().equals(stokKartlari.getStokKodu())).findFirst().isPresent();
    }

    public void Search(){
        String searchText = fieldAra.getText();
        List<StokKartlari> tempList = new ArrayList<StokKartlari>();
        filtredStokKartlariList = new ArrayList<StokKartlari>(stokKartlariList);
        if(searchText != null && !"".equals(searchText)){
            if(filtredStokKartlariList != null && !filtredStokKartlariList.isEmpty()){
                for(StokKartlari stokKartlari : filtredStokKartlariList){
                    if(checkStokKartContains(stokKartlari, searchText)){
                        tempList.add(stokKartlari);
                    }
                }
                filtredStokKartlariList = new ArrayList<StokKartlari>(tempList);
            }
        }
        List();
    }

    private boolean checkStokKartContains (StokKartlari stokKartlari, String searchText){
        return (stokKartlari.getStokKodu() ).toUpperCase(new Locale("tr")).equals(searchText.toUpperCase(new Locale("tr")));
    }

    public String SelectedRow(){
        TableModel model = tableStokKartlari.getModel();
        String value = String.valueOf(model.getValueAt(tableStokKartlari.getSelectedRow(),0));
        return value;
    }

    public void ShowSelected(){
        DefaultTableModel model = (DefaultTableModel)tableStokKartlari.getModel();
        int selectedRowIndex = tableStokKartlari.getSelectedRow();
        if (tableStokKartlari.getRowCount() == 1)
            selectedRowIndex = 0;
        fieldStokKodu.setText(model.getValueAt(selectedRowIndex, 0).toString());
        fieldStokAdi.setText(model.getValueAt(selectedRowIndex, 1).toString());
        comboStokTipi.getModel().setSelectedItem(tableStokKartlari.getValueAt(selectedRowIndex, 2));
        comboBirimi.getModel().setSelectedItem(tableStokKartlari.getValueAt(selectedRowIndex, 3));
        fieldBarkodu.setText(model.getValueAt(selectedRowIndex, 4).toString());
        comboKdvTipi.getModel().setSelectedItem(tableStokKartlari.getValueAt(selectedRowIndex, 5));
        if(model.getValueAt(selectedRowIndex, 6) != null) {
            fieldAciklama.setText(model.getValueAt(selectedRowIndex, 6).toString());
        }
        else fieldAciklama.setText("");
        fieldOlusturmaTarihi.setDate((Date) model.getValueAt(selectedRowIndex, 7));
    }

    public App()  {

        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Stok Kartı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();

        buttonListele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtredStokKartlariList = stokKartlariList;
                List();
            }
        });
        buttonEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add();
                List();
            }
        });
        buttonAra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search();
                ShowSelected();
            }

        });
        buttonSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = dataCollector.deleteStokKarti(SelectedRow());
                stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();
                List();
            }
        });
        tableStokKartlari.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ShowSelected();

            }
        });
        buttonGuncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update();
                List();
            }
        });
        buttonKopyala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Copy();
                List();
            }
        });
    }

    private void createUIComponents() {
        fieldOlusturmaTarihi = new JDateChooser();

    }
}

