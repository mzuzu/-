package xyz.chengzi.halma;

import xyz.chengzi.halma.controller.GameController;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.view.ChessBoardComponent;
import xyz.chengzi.halma.view.GameFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Halma {
    public static ChessBoard chessBoard;

    public static void start(boolean selection) {
        SwingUtilities.invokeLater(() -> {
            ChessBoardComponent chessBoardComponent = new ChessBoardComponent(760, 19);
            chessBoard = new ChessBoard(19);
            GameController controller = new GameController(chessBoardComponent, chessBoard, selection);

            GameFrame mainFrame = new GameFrame();
            mainFrame.add(chessBoardComponent);
            mainFrame.setVisible(true);
        });
    }

    public static void startLoad() {
        FileFilter filter;
        JFileChooser chooser = new JFileChooser("src/LOAD");
        filter = new FileNameExtensionFilter("跳棋存档","halma");
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        chooser.setMultiSelectionEnabled(false);

        SwingUtilities.invokeLater(() -> {
            ChessBoardComponent chessBoardComponent = new ChessBoardComponent(760, 19);
            try {
                ChessBoard chessBoard = new ChessBoard(19);
                GameController controller = new GameController(chessBoardComponent, chessBoard);
                controller.load(file);
                GameFrame mainFrame = new GameFrame();
                mainFrame.add(chessBoardComponent);
                mainFrame.setVisible(true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

}
