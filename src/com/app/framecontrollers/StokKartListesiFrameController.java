package com.app.framecontrollers;
import com.app.views.MainFrame;
import com.app.views.StokKartiListFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartListesiFrameController implements ActionListener {
    StokKartiListFrame iFrame;
    MainFrame mainFrame;

    public StokKartListesiFrameController(MainFrame mainFrame){
        iFrame = new StokKartiListFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);

    }
}
