package xyz.chengzi.halma.controller;

import xyz.chengzi.halma.listener.InputListener;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.model.ChessBoardLocation;
import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.view.ChessBoardComponent;
import xyz.chengzi.halma.view.ChessComponent;
import xyz.chengzi.halma.view.SquareComponent;

import java.awt.*;

public class GameController implements InputListener {
    private ChessBoardComponent view;
    private ChessBoard model;

    private ChessBoardLocation selectedLocation;
    private Color currentPlayer;

    public GameController(ChessBoardComponent chessBoardComponent, ChessBoard chessBoard) {
        this.view = chessBoardComponent;
        this.model = chessBoard;

        this.currentPlayer = Color.RED;
        view.registerListener(this);
        model.registerListener(view);
        model.placeInitialPieces2();
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

    public Color nextPlayer2() {
        return currentPlayer = currentPlayer == Color.RED ? Color.GREEN : Color.RED;
    }

    public Color nextPlayer4() {
        if (currentPlayer == Color.RED) {
            return currentPlayer = Color.YELLOW;
        }
        if (currentPlayer == Color.YELLOW) {
            return currentPlayer = Color.GREEN;
        }
        if (currentPlayer == Color.GREEN) {
            return currentPlayer = Color.BLUE;
        }
        if (currentPlayer == Color.BLUE) {
            return currentPlayer = Color.RED;
        }
        return null;
    }

    @Override
    public void onPlayerClickSquare(ChessBoardLocation location, SquareComponent component) {
        if (hasSelectedLocation() && model.isValidMove(getSelectedLocation(), location)) {
            model.moveChessPiece(selectedLocation, location);
            resetSelectedLocation();
            nextPlayer4();
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
}
