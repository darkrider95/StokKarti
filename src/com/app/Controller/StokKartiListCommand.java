package com.app.Controller;
import com.app.Const.Config;
import com.app.Model.StokKartlari;
import com.app.View.App;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiListCommand  implements ActionListener {

    private static App app;
    public StokKartiListCommand(App app){
        this.app = app;
    }

    public static void list(){
        app.modelStokKartlari = new DefaultTableModel();
        app.modelStokKartlari.setColumnIdentifiers(Config.COLUMN_STOK_LIST);
        app.tableStokKartlari.setModel(app.modelStokKartlari);
        app.tableStokKartlari.getTableHeader().setReorderingAllowed(false);
        app.modelStokKartlari.setRowCount(0);
        for (StokKartlari obj : app.filtredStokKartlariList){
            Object[] row = new Object[Config.COLUMN_STOK_LIST.length];
            row[0] = obj.getStokKodu();
            row[1] = obj.getStokAdi();
            row[2] = obj.getStokTipi();
            row[3] = obj.getBirimi();
            row[4] = obj.getBarkodu();
            row[5] = obj.getKdvTipi();
            row[6] = obj.getAciklama();
            row[7] = obj.getOlusturmaTarihi();
            app.modelStokKartlari.addRow(row);
        }
        app.stokKartlariList = app.filtredStokKartlariList = app.dataCollector.getStokKartiList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        list();
    }
}
