package com.app;
import com.app.controllers.StokKartiSaveCommand;
import com.app.framecontrollers.*;
import com.app.dataaccess.JdbcUtil;
import com.app.views.FocusListener;
import com.app.views.MainFrame;
import com.app.views.StokKartiFrame;

public class Main {

    public static void main(String[] args) {
        JdbcUtil.getInstance();
        MainFrame app = new MainFrame();
        app.setVisible(true);
        app.depoKarti.addActionListener(new DepoKartiFrameController(app));
        app.stokKarti.addActionListener(new StokKartiFrameController(app));
        app.stokKartListesi.addActionListener(new StokKartListesiFrameController(app));
        app.depoKartListesi.addActionListener(new DepoKartıListesiFrameController(app));
        app.birimKartListesi.addActionListener(new BirimKartiListesiFrameController(app));
        app.kdvTipiListesi.addActionListener(new KdvTipiListesiFrameController(app));
        app.birimKarti.addActionListener(new BirimKartiFrameController(app));
        app.kdvTipiKarti.addActionListener(new KdvTipiFrameController(app));
        app.stokTipiKarti.addActionListener(new StokTipiFrameController(app));
        app.stokTipiListesi.addActionListener(new StokTipiListFrameController(app));


    }
}
