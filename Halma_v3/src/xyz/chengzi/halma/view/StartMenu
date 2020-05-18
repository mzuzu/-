package xyz.chengzi.halma.view;

import xyz.chengzi.halma.Halma;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame {
    public StartMenu() {
        setTitle("Halma Start Menu");
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("TIAO QI");
        add(label);

        JButton TPlayer = new JButton("2 Player");
        TPlayer.addActionListener((e) -> Halma.start(true));
        add(TPlayer);

        JButton FPlayer = new JButton("4 Player");
        FPlayer.addActionListener((e) -> Halma.start(false));
        add(FPlayer);

        JButton load = new JButton("Load");
        add(load);

    }
}
