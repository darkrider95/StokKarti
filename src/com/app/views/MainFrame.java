package com.app.views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    public JMenuItem depoKarti;
    public JMenuItem stokKarti;
    public JMenuItem birimKarti;
    public JMenuItem kdvTipiKarti;
    public JMenuItem stokTipiKarti;
    public JMenuItem stokTipiListesi;
    public JMenuItem stokKartListesi;
    public JMenuItem depoKartListesi;
    public JMenuItem birimKartListesi;
    public JMenuItem kdvTipiListesi;
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

        depoKarti = new JMenuItem("Depo Kartları");
        mnStok.add(depoKarti);

        stokKarti = new JMenuItem("Stok Kartları");
        mnStok.add(stokKarti);

        birimKarti = new JMenuItem("Birim Kartları");
        mnStok.add(birimKarti);

        stokTipiKarti = new JMenuItem("Stok Tipi Kartları");
        mnStok.add(stokTipiKarti);

        kdvTipiKarti = new JMenuItem("Kdv Tipi Kartları");
        mnStok.add(kdvTipiKarti);

        stokKartListesi = new JMenuItem("Stok Kart Listesi");
        mnStok.add(stokKartListesi);

        stokTipiListesi = new JMenuItem("Stok Tipi Listesi");
        mnStok.add(stokTipiListesi);

        depoKartListesi = new JMenuItem("Depo Kart Listesi");
        mnStok.add(depoKartListesi);

        birimKartListesi = new JMenuItem("Birim Kart Listesi");
        mnStok.add(birimKartListesi);

        kdvTipiListesi = new JMenuItem("Kdv Tipi Listesi");
        mnStok.add(kdvTipiListesi);

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
            frame.setClosable(true);
            setContentPane(desktopPane);
            desktopPane.putClientProperty("JDesktopPane.dragMode", "outline");

        } else {
            frame.toFront();
        }
    }
}
