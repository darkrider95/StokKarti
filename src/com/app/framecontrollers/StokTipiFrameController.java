package com.app.framecontrollers;
import com.app.views.MainFrame;
import com.app.views.StokTipiFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokTipiFrameController implements ActionListener {

    StokTipiFrame iFrame;
    MainFrame mainFrame;

    public StokTipiFrameController(MainFrame mainFrame){
        iFrame = new StokTipiFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);
    }
}
