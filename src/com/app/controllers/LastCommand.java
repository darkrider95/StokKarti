package com.app.controllers;

import com.app.face.BaseInternalFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LastCommand implements ActionListener {
    public BaseInternalFrame iFrame;
    public LastCommand(BaseInternalFrame iFrame) {
        this.iFrame = iFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            iFrame.setSearchedField(iFrame.prepareNewModel(3));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
