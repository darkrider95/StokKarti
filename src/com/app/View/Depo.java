package com.app.View;
import com.app.Controller.DepoDataCollector;
import com.app.Controller.DepoListCommand;
import com.app.Model.DepoModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Depo extends JFrame {
    public JTable tableDepo;
    private JButton buttonListele;
    private JPanel mainField;

    public DefaultTableModel modelDepo;
    public DepoDataCollector dataCollector;
    public ArrayList<DepoModel> depoList;
    public ArrayList<DepoModel> filtredDepoList;

    public Depo(){
        setContentPane(mainField);
        setSize(1000,600);
        setTitle("Depo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        depoList = filtredDepoList = dataCollector.getDepoList();
        DepoListCommand listCommand = null;
        buttonListele.addActionListener(listCommand = new DepoListCommand(this));
    }
}
