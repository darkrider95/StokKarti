package com.app.framecontrollers;
import com.app.views.DepoKartiFrame;
import com.app.views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepoKartiFrameController implements ActionListener {

    DepoKartiFrame iFrame;
    MainFrame mainFrame;

    public DepoKartiFrameController(MainFrame mainFrame){
        iFrame = new DepoKartiFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);
    }
}
