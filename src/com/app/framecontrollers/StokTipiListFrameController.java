package com.app.framecontrollers;
import com.app.views.MainFrame;
import com.app.views.StokTipiListFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokTipiListFrameController implements ActionListener {
    StokTipiListFrame iFrame;
    MainFrame mainFrame;

    public StokTipiListFrameController(MainFrame mainFrame){
        iFrame = new StokTipiListFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);
    }
}
