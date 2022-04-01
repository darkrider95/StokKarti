package com.app.views;
import com.app.Const.Config;
import com.app.controllers.ExtractToExcel;
import com.app.controllers.ExtractToPdf;
import com.app.controllers.SendMailWithAttachment;
import com.app.datacollectors.StokKartiDataCollector;
import com.app.models.StokKartiModel;
import net.sf.jasperreports.engine.JRException;
import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static com.app.Const.Config.STOK_LIST_JASPER_PATH;

public class StokKartiListFrame  extends JInternalFrame  {

    public JTable tableStokKartlari;
    private JButton button1;
    public DefaultTableModel modelStokKartlari;
    public ArrayList<StokKartiModel> stokKartlariList;
    public ArrayList<StokKartiModel> filtredStokKartlariList;
    public StokKartiDataCollector dataCollector;
    private JPanel mainField;


    public void list() {
        modelStokKartlari = new DefaultTableModel();
        modelStokKartlari.setColumnIdentifiers(Config.COLUMN_STOK_LIST);
        tableStokKartlari.setModel(modelStokKartlari);
        tableStokKartlari.getTableHeader().setReorderingAllowed(false);
        modelStokKartlari.setRowCount(0);
        for (StokKartiModel obj : filtredStokKartlariList) {
            Object[] row = new Object[Config.COLUMN_STOK_LIST.length];
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
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();
    }

    public StokKartiListFrame() {
        setContentPane(mainField);
        setSize(1000, 600);
        setTitle("Stok Kart Listesi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stokKartlariList = filtredStokKartlariList = dataCollector.getStokKartiList();

        button1.addActionListener(e -> list());
        PopupMenuExample();
    }


    void PopupMenuExample(){
        JPopupMenu popupmenu = new JPopupMenu("Extract");
        JMenuItem pdf = new JMenuItem("Pdf");
        JMenuItem mail = new JMenuItem("Mail");
        JMenuItem excel = new JMenuItem("Excel");

        popupmenu.add(pdf);
        popupmenu.add(mail);
        popupmenu.add(excel);

        setComponentPopupMenu(popupmenu);
        tableStokKartlari.setComponentPopupMenu(popupmenu);

        pdf.addActionListener(e -> {
            ExtractToPdf extractToPdf = new ExtractToPdf(filtredStokKartlariList, STOK_LIST_JASPER_PATH);
            try {
                extractToPdf.print();
            } catch (JRException ex) {
                ex.printStackTrace();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        mail.addActionListener(e -> {
            try {
                SendMailWithAttachment sendMailWithAttachment = new SendMailWithAttachment();
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }

        });

        excel.addActionListener(e -> {
            try {
                ExtractToExcel extractToExcel = new ExtractToExcel(tableStokKartlari);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }

}


