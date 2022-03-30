package com.app.controllers;
import com.app.views.StokKartiFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class FillFieldsWhenClicked implements MouseListener {

    private static StokKartiFrame app;
    public FillFieldsWhenClicked(StokKartiFrame app){
        this.app = app;
    }

    public static void fillFieldsWhenClicked(){
        try {
            DefaultTableModel model = (DefaultTableModel)app.tableStokKartlari.getModel();
            int selectedRowIndex = app.tableStokKartlari.getSelectedRow();
            if (app.tableStokKartlari.getRowCount() == 1)
                selectedRowIndex = 0;
            app.fieldStokKodu.setText(model.getValueAt(selectedRowIndex, 0).toString());
            app.fieldStokAdi.setText(model.getValueAt(selectedRowIndex, 1).toString());
            app.comboStokTipi.getModel().setSelectedItem(app.tableStokKartlari.getValueAt(selectedRowIndex, 2));
            app.comboBirimi.getModel().setSelectedItem(app.tableStokKartlari.getValueAt(selectedRowIndex, 3));
            app.fieldBarkodu.setText(model.getValueAt(selectedRowIndex, 4).toString());
            app.comboKdvTipi.getModel().setSelectedItem(app.tableStokKartlari.getValueAt(selectedRowIndex, 5));
            if(model.getValueAt(selectedRowIndex, 6) != null) {
                app.fieldAciklama.setText(model.getValueAt(selectedRowIndex, 6).toString());
            }
            else app.fieldAciklama.setText("");
            app.fieldOlusturmaTarihi.setDate((Date) model.getValueAt(selectedRowIndex, 7));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        fillFieldsWhenClicked();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
