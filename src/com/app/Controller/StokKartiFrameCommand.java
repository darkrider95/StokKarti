package com.app.Controller;
import com.app.View.MainFrame;
import com.app.View.StokKartiFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokKartiFrameCommand implements ActionListener {
    StokKartiFrame iFrame;
    MainFrame mainFrame;


    public StokKartiFrameCommand(MainFrame mainFrame){
        iFrame = new StokKartiFrame();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.createFrame(iFrame);

    }
}
