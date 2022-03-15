package com.app.Controller;
import com.app.View.App;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiDeleteCommand implements ActionListener {

    private App app;
    public StokKartiDeleteCommand(App app){
        this.app = app;
    }

    public String SelectedRow(){
        TableModel model = app.tableStokKartlari.getModel();
        String value = String.valueOf(model.getValueAt(app.tableStokKartlari.getSelectedRow(),0));
        return value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean result = app.dataCollector.deleteStokKarti(SelectedRow());
        app.stokKartlariList = app.filtredStokKartlariList = app.dataCollector.getStokKartiList();
        StokKartiListCommand.list();
    }
}
