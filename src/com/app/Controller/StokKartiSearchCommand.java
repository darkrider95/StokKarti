package com.app.Controller;
import com.app.Model.StokKartlari;
import com.app.View.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StokKartiSearchCommand implements ActionListener {

    private App app;
    public StokKartiSearchCommand(App app){
        this.app = app;
    }

    public void search(){
        String searchText = app.fieldAra.getText();
        List<StokKartlari> tempList = new ArrayList<StokKartlari>();
        app.filtredStokKartlariList = new ArrayList<StokKartlari>(app.stokKartlariList);
        if(searchText != null && !"".equals(searchText)){
            if(app.filtredStokKartlariList != null && !app.filtredStokKartlariList.isEmpty()){
                for(StokKartlari stokKartlari : app.filtredStokKartlariList){
                    if(checkStokKartContains(stokKartlari, searchText)){
                        tempList.add(stokKartlari);
                    }
                }
                app.filtredStokKartlariList = new ArrayList<StokKartlari>(tempList);
            }
        }
    }

    private boolean checkStokKartContains (StokKartlari stokKartlari, String searchText){
        return (stokKartlari.getStokKodu() ).toUpperCase(new Locale("tr")).equals(searchText.toUpperCase(new Locale("tr")));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        search();
        StokKartiListCommand.list();
        FillFieldsWhenClicked.fillFieldsWhenClicked();
    }
}
