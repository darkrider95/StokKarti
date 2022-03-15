package com.app.View;
import com.app.Controller.ExtractToExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MenuBar {

    public static JMenuBar createMenuBar(App app) {
        JMenuBar menuBar;
        JMenu menu ;
        JMenuItem extractToExcel;

        menuBar = new JMenuBar();
        menu = new JMenu("Dışarıya Aktar");
        menuBar.add(menu);

        extractToExcel = new JMenuItem("Excel Olarak Dışa Aktar");
        menu.add(extractToExcel);


        extractToExcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ExtractToExcel execute = new ExtractToExcel(app);
                    execute.integrate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        return menuBar;
    }
}

