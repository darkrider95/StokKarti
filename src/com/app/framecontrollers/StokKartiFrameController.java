package com.app.framecontrollers;
import com.app.views.MainFrame;
import com.app.views.StokKartiFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiFrameController implements ActionListener {
    StokKartiFrame iFrame;
    MainFrame mainFrame;

    public StokKartiFrameController(MainFrame mainFrame){
        iFrame = new StokKartiFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);

    }
}
