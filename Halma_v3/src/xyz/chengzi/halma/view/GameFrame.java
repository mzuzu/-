package xyz.chengzi.halma.view;

import xyz.chengzi.halma.Halma;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Halma Game");
        setSize(776, 820);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel statusLabel = new JLabel("Sample label");
        statusLabel.setLocation(0, 760);
        statusLabel.setSize(200, 10);
        add(statusLabel);

        JButton button = new JButton("...");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Button clicked!"));
        button.setLocation(740, 760);
        button.setSize(20, 12);
        add(button);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLocation(0,0);
        menuBar.setSize(776,20);

        JMenu menu = new JMenu("Menu");

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener((e) -> Halma.chessBoard.save());

        JMenuItem load = new JMenuItem("Load");
        load.addActionListener((e) -> Halma.startLoad());

        JMenuItem replay = new JMenuItem("Replay");


        JMenuItem neg = new JMenuItem("New Game");


        menu.add(save);
        menu.add(load);
        menu.add(replay);
        menu.add(neg);
        menuBar.add(menu);
        add(menuBar);
    }
}
