package com.app.framecontrollers;
import com.app.views.BirimKartiListFrame;
import com.app.views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirimKartiListesiFrameController implements ActionListener {

    BirimKartiListFrame iFrame;
    MainFrame mainFrame;
    public BirimKartiListesiFrameController(MainFrame mainFrame){
        iFrame = new BirimKartiListFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);
    }
}
