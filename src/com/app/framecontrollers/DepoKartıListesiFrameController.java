package com.app.framecontrollers;
import com.app.views.DepoKartiListFrame;
import com.app.views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepoKartıListesiFrameController implements ActionListener {

    DepoKartiListFrame iFrame;
    MainFrame mainFrame;
    public DepoKartıListesiFrameController(MainFrame mainFrame){
        iFrame = new DepoKartiListFrame(mainFrame);
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);
    }
}
