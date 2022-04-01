package com.app.views;
import com.app.face.BaseInternalFrame;
import javax.swing.*;
import java.awt.event.FocusEvent;
public class FocusListener implements java.awt.event.FocusListener {

    public JTextField masterField;
    private JTextField adiField;
    BaseInternalFrame iFrame;
    public FocusListener(JTextField masterField, JTextField adiField, BaseInternalFrame iFrame) {
        this.masterField = masterField;
        this.adiField = adiField;
        this.iFrame = iFrame;
        masterField.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        String value = masterField.getText();
        iFrame.setSearchedField(value);

    }
}
