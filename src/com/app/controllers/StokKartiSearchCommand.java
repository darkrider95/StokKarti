package com.app.controllers;
import com.app.models.StokKartiModel;
import com.app.views.StokKartiFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StokKartiSearchCommand implements ActionListener {

    private StokKartiFrame iFrame;
    public StokKartiSearchCommand(StokKartiFrame iFrame){
        this.iFrame = iFrame;
    }

    public void search(){
        String searchText = iFrame.fieldAra.getText();
        List<StokKartiModel> tempList = new ArrayList<StokKartiModel>();
        iFrame.filtredStokKartlariList = new ArrayList<StokKartiModel>(iFrame.stokKartlariList);
        if(searchText != null && !"".equals(searchText)){
            if(iFrame.filtredStokKartlariList != null && !iFrame.filtredStokKartlariList.isEmpty()){
                for(StokKartiModel stokKartlari : iFrame.filtredStokKartlariList){
                    if(checkStokKartContains(stokKartlari, searchText)){
                        tempList.add(stokKartlari);
                    }
                }
                iFrame.filtredStokKartlariList = new ArrayList<StokKartiModel>(tempList);
            }
        }
    }

    private boolean checkStokKartContains (StokKartiModel stokKartlari, String searchText){
        return (stokKartlari.getStokKodu() ).toUpperCase(new Locale("tr")).equals(searchText.toUpperCase(new Locale("tr")));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        search();
        FillFieldsWhenClicked.fillFieldsWhenClicked();
    }
}
