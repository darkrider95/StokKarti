package com.app.framecontrollers;
import com.app.views.KdvTipiListFrame;
import com.app.views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KdvTipiListesiFrameController implements ActionListener {

    KdvTipiListFrame iFrame;
    MainFrame mainFrame;

    public KdvTipiListesiFrameController(MainFrame mainFrame){
        iFrame = new KdvTipiListFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);
    }
}
