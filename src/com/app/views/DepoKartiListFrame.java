package com.app.views;
import com.app.Const.Config;
import com.app.controllers.ExtractToPdf;
import com.app.datacollectors.DepoKartiDataCollector;
import com.app.models.DepoKartiModel;
import net.sf.jasperreports.engine.JRException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static com.app.Const.Config.DEPO_LIST_JASPER_PATH;

public class DepoKartiListFrame extends JInternalFrame {
    private JButton button1;
    private JTable tableDepoKartlari;
    private JPanel mainField;

    public DefaultTableModel modelDepoKartlari;
    public ArrayList<DepoKartiModel> depoKartlariList;
    public ArrayList<DepoKartiModel> filteredDepoKartlariList;
    public DepoKartiDataCollector dataCollector;
    public MainFrame mainFrame;

    public void list(){
        modelDepoKartlari = new DefaultTableModel();
        modelDepoKartlari.setColumnIdentifiers(Config.COLUMN_DEPO_LIST);
        tableDepoKartlari.setModel(modelDepoKartlari);
        tableDepoKartlari.getTableHeader().setReorderingAllowed(false);
        modelDepoKartlari.setRowCount(0);
        for (DepoKartiModel obj : filteredDepoKartlariList){
            Object[] row = new Object[Config.COLUMN_DEPO_LIST.length];
            row[0] = obj.getDepoKodu();
            row[1] = obj.getDepoAdi();
            row[2] = obj.getDepoAciklama();
            modelDepoKartlari.addRow(row);
        }
        depoKartlariList = filteredDepoKartlariList = dataCollector.getDepoKartlariList();
    }

    public DepoKartiListFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setContentPane(mainField);
        setSize(1000, 600);
        setTitle("Depo Kart Listesi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        depoKartlariList = filteredDepoKartlariList = dataCollector.getDepoKartlariList();

        button1.addActionListener(e -> list());

        PopupMenuExample();
    }

    void PopupMenuExample(){
        JPopupMenu popupmenu = new JPopupMenu("Extract");
        JMenuItem cut = new JMenuItem("Pdf");

        popupmenu.add(cut);
        setComponentPopupMenu(popupmenu);
        tableDepoKartlari.setComponentPopupMenu(popupmenu);
        cut.addActionListener(e -> {
            ExtractToPdf extractToPdf = new ExtractToPdf(filteredDepoKartlariList, DEPO_LIST_JASPER_PATH);
            try {
                extractToPdf.print();
            } catch (JRException ex) {
                ex.printStackTrace();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

    }
}
