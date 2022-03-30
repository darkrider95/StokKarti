package com.app.framecontrollers;
import com.app.views.BirimKartiFrame;
import com.app.views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirimKartiFrameController implements ActionListener {

    BirimKartiFrame iFrame;
    MainFrame mainFrame;

    public BirimKartiFrameController(MainFrame mainFrame){
        iFrame = new BirimKartiFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);
    }
}
