package com.app.View;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    public JMenuItem depoKarti;
    public JMenuItem stokKarti;
    public JDesktopPane desktopPane;
    private JPanel contentPane;

    public MainFrame(){
        this.setVisible(false);
        Init();
    }

    private void Init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1082, 780);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnStok = new JMenu("Stok");
        menuBar.add(mnStok);

        depoKarti = new JMenuItem("Stok Listesi");
        mnStok.add(depoKarti);

        stokKarti = new JMenuItem("Stok Kartları");
        mnStok.add(stokKarti);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.DARK_GRAY);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE).addContainerGap()));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(desktopPane,
                GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));

        contentPane.setLayout(gl_contentPane);
    }

    public void createFrame(JInternalFrame frame) {
        if (frame.isVisible() == false) {
            frame.setVisible(true);
            desktopPane.add(frame);
            try {
                frame.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
                System.out.println(e);
            }
            setContentPane(desktopPane);
            desktopPane.putClientProperty("JDesktopPane.dragMode", "outline");
        } else {
            return;
        }
    }
}
