package xyz.chengzi.halma.controller;

import xyz.chengzi.halma.listener.InputListener;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.model.ChessBoardLocation;
import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.view.ChessBoardComponent;
import xyz.chengzi.halma.view.ChessComponent;
import xyz.chengzi.halma.view.SquareComponent;

import java.awt.*;

public class GameController implements InputListener{
    private ChessBoardComponent view;
    private ChessBoard model;
    private KeyEvent keyEvent;
    private ChessBoardLocation selectedLocation;
    private Color currentPlayer;
    public boolean moShi; //模式 true is two players, false is four players.

    public void setMoShi(boolean moShi) {
        this.moShi = moShi;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameController(ChessBoardComponent chessBoardComponent, ChessBoard chessBoard, boolean selection) {
        this.moShi = selection;
        chessBoard.setMoShi(selection);
        this.view = chessBoardComponent;
        this.model = chessBoard;

        this.currentPlayer = FirstPlayer();
        view.registerListener(this);
        model.registerListener(view);
        model.placeInitialPieces();
    }

    public GameController(ChessBoardComponent chessBoardComponent, ChessBoard chessBoard) {
        this.view = chessBoardComponent;
        this.model = chessBoard;

        view.registerListener(this);
        model.registerListener(view);
        setMoShi(model.isMoShi());
    }

    public Color FirstPlayer() {
        if (moShi) {
            int a = (int) (Math.random() * 2);
            if (a == 0)
                return Color.RED;
            else
                return Color.GREEN;
        } else {
            int a = (int) (Math.random() * 4);
            if (a == 0)
                return Color.RED;
            else if (a == 1)
                return Color.YELLOW;
            else if (a == 2)
                return Color.GREEN;
            else
                return Color.BLUE;
        }
    }

    public ChessBoardLocation getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(ChessBoardLocation location) {
        this.selectedLocation = location;
    }

    public void resetSelectedLocation() {
        setSelectedLocation(null);
    }

    public boolean hasSelectedLocation() {
        return selectedLocation != null;
    }

    public void SelectMoShi(boolean selection) {
        this.moShi = selection;
    }

    public void nextPlayer(boolean MoShi) {
        if (MoShi) {
            currentPlayer = currentPlayer == Color.RED ? Color.GREEN : Color.RED;
        } else {
            if (currentPlayer == Color.RED) {
                currentPlayer = Color.YELLOW;
                return;
            }
            if (currentPlayer == Color.YELLOW) {
                currentPlayer = Color.GREEN;
                return;
            }
            if (currentPlayer == Color.GREEN) {
                currentPlayer = Color.BLUE;
                return;
            }
            if (currentPlayer == Color.BLUE) {
                currentPlayer = Color.RED;
            }
        }
    }


    @Override
    public void ClickRight() {
        //if(e.isMetaDown()){//检测鼠标右键单击
        nextPlayer(moShi);
        model.setFirstMove(1);
        // }
    }



    @Override
    public void onPlayerClickSquare(ChessBoardLocation location, SquareComponent component) {
        if (hasSelectedLocation() && model.isValidMove(getSelectedLocation(), location)) {
            model.moveChessPiece(selectedLocation, location);
            resetSelectedLocation();//注意，在这里实现连跳
            /*if(button被点击)
                nextPlayer(moShi);
             else
                this.currentPlayer=currentPlayer
            */


        }
    }

    @Override
    public void onPlayerClickChessPiece(ChessBoardLocation location, ChessComponent component) {
        ChessPiece piece = model.getChessPieceAt(location);
        if (piece.getColor() == currentPlayer && (!hasSelectedLocation() || location.equals(getSelectedLocation()))) {
            if (!hasSelectedLocation()) {
                setSelectedLocation(location);
            } else {
                resetSelectedLocation();
            }
            component.setSelected(!component.isSelected());
            component.repaint();
        }
    }

    public void load(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String moshi = scanner.nextLine();

        boolean moSHI;
        if (moshi.equals("2PLAYER"))
            moSHI = true;
        else moSHI = !moshi.equals("4PLAYER");
        setMoShi(moSHI);

        String color = scanner.nextLine();
        setCurrentPlayer(new Color(Integer.parseInt(color)));

        while (scanner.hasNextLine()) {
            String piece = scanner.nextLine();
            String[] piece1 = piece.split("&");
            int i = Integer.parseInt(piece1[1]);
            int j = Integer.parseInt(piece1[2]);
            Color color1 = new Color(Integer.parseInt(piece1[0]));
            model.initialSet(i, j, color1);
        }

    }
}
