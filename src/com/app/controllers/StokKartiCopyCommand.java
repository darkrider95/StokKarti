package com.app.controllers;
import com.app.models.StokKartiModel;
import com.app.views.StokKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiCopyCommand implements ActionListener {

    private StokKartiFrame iFrame;
    private StokKartiSaveCommand saveCommand;
    public StokKartiCopyCommand(StokKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.iFrame = saveCommand.iFrame;
    }

    public void copy(){
        StokKartiModel stokKartlari = saveCommand.getFieldData();
        if(checkStokKodu(stokKartlari.getStokKodu())){
            iFrame.dataCollector.addStokKarti(stokKartlari);
        }else{
            String value = JOptionPane.showInputDialog(this, "Yeni stok kartı için Stok Kodu girin.");
            if(value != null){
                if(checkStokKodu(value)){
                    stokKartlari.setStokKodu(value);
                    iFrame.dataCollector.addStokKarti(stokKartlari);
                }else{
                    JOptionPane.showMessageDialog(null, "Eşsiz bir stok kodu girin.", "",JOptionPane.INFORMATION_MESSAGE);
                    copy();
                }
            }
        }
        iFrame.stokKartlariList = iFrame.filtredStokKartlariList = iFrame.dataCollector.getStokKartiList();
    }

    public boolean checkStokKodu(String value){
        for(StokKartiModel stokKartlari : iFrame.stokKartlariList){
            if(stokKartlari.getStokKodu().equals(value))
                return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        copy();
    }
}

/*delete command injection
stokkarti listesi için ayrı frame
framecontrollers
internal frame kapat küçült butonları
kdv tip kartı kodu adı
birim kartı kodu adı
stok tipi kartı kodu adı
stok kartında combobox depo isimlerini gösterecek
 */

