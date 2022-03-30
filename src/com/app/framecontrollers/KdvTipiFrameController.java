package com.app.framecontrollers;
import com.app.views.KdvTipiFrame;
import com.app.views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KdvTipiFrameController implements ActionListener {

    KdvTipiFrame iFrame;
    MainFrame mainFrame;

    public KdvTipiFrameController(MainFrame mainFrame){
        iFrame = new KdvTipiFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);
    }
}
