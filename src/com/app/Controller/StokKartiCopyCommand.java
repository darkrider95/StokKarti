package com.app.Controller;
import com.app.Model.StokKartlari;
import com.app.View.StokKartiFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiCopyCommand implements ActionListener {

    private StokKartiFrame app;
    private StokKartiSaveCommand saveCommand;
    public StokKartiCopyCommand(StokKartiSaveCommand saveCommand){
        this.saveCommand = saveCommand;
        this.app = saveCommand.iFrame;
    }

    public void copy(){
        StokKartlari stokKartlari = saveCommand.getFieldData();
        if(checkStokKodu(stokKartlari.getStokKodu())){
            app.dataCollector.addStokKarti(stokKartlari);
        }else{
            String value = JOptionPane.showInputDialog(this, "Yeni stok kartı için Stok Kodu girin.");
            if(value != null){
                if(checkStokKodu(value)){
                    stokKartlari.setStokKodu(value);
                    app.dataCollector.addStokKarti(stokKartlari);
                }else{
                    JOptionPane.showMessageDialog(null, "Eşsiz bir stok kodu girin.", "",JOptionPane.INFORMATION_MESSAGE);
                    copy();
                }
            }
        }
        app.stokKartlariList = app.filtredStokKartlariList = app.dataCollector.getStokKartiList();
    }

    public boolean checkStokKodu(String value){
        for(StokKartlari stokKartlari : app.stokKartlariList){
            if(stokKartlari.getStokKodu().equals(value))
                return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        copy();
        StokKartiListCommand.list();
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