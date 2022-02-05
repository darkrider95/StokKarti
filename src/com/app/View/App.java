package com.app.View;

import com.app.Model.StokKartlari;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{

    private JButton button_ekle;
    private JButton button_ara;
    private JButton button_sil;
    private JButton button_guncelle;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox olusturmaTarihiComboBox;
    private JTextArea açıklamaTextArea;
    private JFormattedTextField formattedTextField1;
    private JTextField textField2;

    private JPanel mainField;
    private JTable table_stok_kartlari;
    private JScrollPane scroll_stok_kartlari;
    private JButton button_listele;
    private JButton button_kopyala;

    private DefaultTableModel model_stok_kartlari;
    private Object[] row_stok_kartlari;

    public App()  {
        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Stok Kartı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        //stokList
        model_stok_kartlari = new DefaultTableModel();
        Object[] col_stok_list  = {"Stok Kodu", "Stok Adı", "Stok Tipi", "Birimi", "Barkodu", "KDV Tipi", "Açıklama", "Oluşturma Tarihi"};
        model_stok_kartlari.setColumnIdentifiers(col_stok_list);

        table_stok_kartlari.setModel(model_stok_kartlari);
        table_stok_kartlari.getTableHeader().setReorderingAllowed(false);

        button_listele.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (StokKartlari obj : StokKartlari.getList()){
                    Object[] row = new Object[col_stok_list.length];
                    row[0] = obj.getStok_kodu();
                    row[1] = obj.getStok_adi();
                    row[2] = obj.getStok_tipi();
                    row[3] = obj.getBirimi();
                    row[4] = obj.getBarkodu();
                    row[5] = obj.getKdv_tipi();
                    row[6] = obj.getAciklama();
                    row[7] = obj.getOlusturma_tarihi();
                    model_stok_kartlari.addRow(row);
                }
            }
        });
    }

}

