package xyz.chengzi.halma.model;

import xyz.chengzi.halma.listener.GameListener;
import xyz.chengzi.halma.listener.Listenable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard implements Listenable<GameListener> {
    private List<GameListener> listenerList = new ArrayList<>();
    private Square[][] grid;
    private int dimension;

    public ChessBoard(int dimension) {
        this.grid = new Square[dimension][dimension];
        this.dimension = dimension;

        initGrid();
    }

    private void initGrid() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grid[i][j] = new Square(new ChessBoardLocation(i, j));
            }
        }
    }

    public void placeInitialPieces2() {
        // TODO: This is only a demo implementation
        grid[0][0].setPiece(new ChessPiece(Color.RED));
        grid[0][1].setPiece(new ChessPiece(Color.RED));
        grid[0][2].setPiece(new ChessPiece(Color.RED));
        grid[0][3].setPiece(new ChessPiece(Color.RED));
        grid[0][4].setPiece(new ChessPiece(Color.RED));
        grid[1][0].setPiece(new ChessPiece(Color.RED));
        grid[1][1].setPiece(new ChessPiece(Color.RED));
        grid[1][2].setPiece(new ChessPiece(Color.RED));
        grid[1][3].setPiece(new ChessPiece(Color.RED));
        grid[1][4].setPiece(new ChessPiece(Color.RED));
        grid[2][0].setPiece(new ChessPiece(Color.RED));
        grid[2][1].setPiece(new ChessPiece(Color.RED));
        grid[2][2].setPiece(new ChessPiece(Color.RED));
        grid[2][3].setPiece(new ChessPiece(Color.RED));
        grid[3][0].setPiece(new ChessPiece(Color.RED));
        grid[3][1].setPiece(new ChessPiece(Color.RED));
        grid[3][2].setPiece(new ChessPiece(Color.RED));
        grid[4][0].setPiece(new ChessPiece(Color.RED));
        grid[4][1].setPiece(new ChessPiece(Color.RED));
        grid[dimension - 1][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 5].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 5].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 5][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 5][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        listenerList.forEach(listener -> listener.onChessBoardReload(this));
    }

    public void placeInitialPieces4() {
        grid[0][0].setPiece(new ChessPiece(Color.RED));
        grid[0][1].setPiece(new ChessPiece(Color.RED));
        grid[0][2].setPiece(new ChessPiece(Color.RED));
        grid[0][3].setPiece(new ChessPiece(Color.RED));
        grid[1][0].setPiece(new ChessPiece(Color.RED));
        grid[1][1].setPiece(new ChessPiece(Color.RED));
        grid[1][2].setPiece(new ChessPiece(Color.RED));
        grid[1][3].setPiece(new ChessPiece(Color.RED));
        grid[2][0].setPiece(new ChessPiece(Color.RED));
        grid[2][1].setPiece(new ChessPiece(Color.RED));
        grid[2][2].setPiece(new ChessPiece(Color.RED));
        grid[3][0].setPiece(new ChessPiece(Color.RED));
        grid[3][1].setPiece(new ChessPiece(Color.RED));
        grid[dimension - 1][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[0][dimension - 1].setPiece(new ChessPiece(Color.YELLOW));
        grid[0][dimension - 2].setPiece(new ChessPiece(Color.YELLOW));
        grid[0][dimension - 3].setPiece(new ChessPiece(Color.YELLOW));
        grid[0][dimension - 4].setPiece(new ChessPiece(Color.YELLOW));
        grid[1][dimension - 1].setPiece(new ChessPiece(Color.YELLOW));
        grid[1][dimension - 2].setPiece(new ChessPiece(Color.YELLOW));
        grid[1][dimension - 3].setPiece(new ChessPiece(Color.YELLOW));
        grid[1][dimension - 4].setPiece(new ChessPiece(Color.YELLOW));
        grid[2][dimension - 1].setPiece(new ChessPiece(Color.YELLOW));
        grid[2][dimension - 2].setPiece(new ChessPiece(Color.YELLOW));
        grid[2][dimension - 3].setPiece(new ChessPiece(Color.YELLOW));
        grid[3][dimension - 1].setPiece(new ChessPiece(Color.YELLOW));
        grid[3][dimension - 2].setPiece(new ChessPiece(Color.YELLOW));
        grid[dimension - 1][0].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 1][1].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 1][2].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 1][3].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 2][0].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 2][1].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 2][2].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 2][3].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 3][0].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 3][1].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 3][2].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 4][0].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 4][1].setPiece(new ChessPiece(Color.BLUE));
        listenerList.forEach(listener -> listener.onChessBoardReload(this));
    }

    public Square getGridAt(ChessBoardLocation location) {
        return grid[location.getRow()][location.getColumn()];
    }

    public ChessPiece getChessPieceAt(ChessBoardLocation location) {
        return getGridAt(location).getPiece();
    }

    public void setChessPieceAt(ChessBoardLocation location, ChessPiece piece) {
        getGridAt(location).setPiece(piece);
        listenerList.forEach(listener -> listener.onChessPiecePlace(location, piece));
    }

    public ChessPiece removeChessPieceAt(ChessBoardLocation location) {
        ChessPiece piece = getGridAt(location).getPiece();
        getGridAt(location).setPiece(null);
        listenerList.forEach(listener -> listener.onChessPieceRemove(location));
        return piece;
    }

    public void moveChessPiece(ChessBoardLocation src, ChessBoardLocation dest) {
        if (!isValidMove(src, dest)) {
            throw new IllegalArgumentException("Illegal halma move");
        }
        setChessPieceAt(dest, removeChessPieceAt(src));
    }

    public int getDimension() {
        return dimension;
    }

    public boolean isValidMove(ChessBoardLocation src, ChessBoardLocation dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if (rowDistance != 0 && colDistance != 0 && Math.abs((double) rowDistance / colDistance) != 1.0) {
            return false;
        }
        return Math.abs(rowDistance) <= 1 && Math.abs(colDistance) <= 1;
    }

    @Override
    public void registerListener(GameListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void unregisterListener(GameListener listener) {
        listenerList.remove(listener);
    }
}
