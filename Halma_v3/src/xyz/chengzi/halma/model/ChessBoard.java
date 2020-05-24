package xyz.chengzi.halma.model;

import xyz.chengzi.halma.controller.GameController;
import xyz.chengzi.halma.listener.GameListener;
import xyz.chengzi.halma.listener.Listenable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard implements Listenable<GameListener> {
    private List<GameListener> listenerList = new ArrayList<>();
    private Square[][] grid;
    private int dimension;
    private Color player;
    private boolean MoShi;
    private int FirstMove=1;
    private ChessBoardLocation src;

    public  int getFirstMove() {
        return FirstMove;
    }

    public void setFirstMove(int firstMove) {
        FirstMove = firstMove;
    }

    public Square[][] getGrid() {
        return grid;
    }

    public void setMoShi(boolean moShi) {
        MoShi = moShi;
    }

    public boolean isMoShi() {
        return MoShi;
    }

    public void setPlayer(Color player) {
        this.player = player;
    }

    public Color getPlayer() {

        return player;
    }

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

    public void initialSet(int i, int j, Color color){
        grid[i][j].setPiece(new ChessPiece(color));
        listenerList.forEach(listener -> listener.onChessBoardReload(this));
    }

    public void placeInitialPieces() {
        // TODO: This is only a demo implementation
        if (MoShi) {
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
        } else {
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
        }
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
        if (FirstMove==1){
            if (!isValidMove(src, dest)) {
                throw new IllegalArgumentException("Illegal halma move");
            }
            this.src=dest;
            setChessPieceAt(dest, removeChessPieceAt(src));
            FirstMove--;
        }
        else {
            if (!isJump(this.src,dest))
                throw new IllegalArgumentException("Illegal halma move");
            setChessPieceAt(dest, removeChessPieceAt(src));
        }
    }


    public int getDimension() {
        return dimension;
    }

    public boolean isValidMove(ChessBoardLocation src, ChessBoardLocation dest) {
        if(!isWin()){
            if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
                return false;
            }
            int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
            int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
            if (rowDistance != 0 && colDistance != 0 && Math.abs((double) rowDistance / colDistance) != 1.0) {
                return false;
            }
            if (Math.abs(rowDistance) <= 1 && Math.abs(colDistance) <= 1)
                return true;
            else return isJump(src,dest);
        }
        else return false;
    }



    public boolean isJump(ChessBoardLocation src, ChessBoardLocation dest){
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if (rowDistance != 0 && colDistance != 0 && Math.abs((double) rowDistance / colDistance) != 1.0) {
            return false;
        }
        if (Math.abs(rowDistance)>2||Math.abs(colDistance)>2)
            return false;
        if (Math.abs(rowDistance)==1&&Math.abs(colDistance)==1)
            return false;
        int total=Math.abs(rowDistance)+Math.abs(colDistance);
        if (total == 2 || total == 4){
            int middleRow=(srcRow+destRow)/2;
            int middleCol=(srcCol+destCol)/2;
            ChessBoardLocation middle=new ChessBoardLocation(middleRow,middleCol);
            return getChessPieceAt(middle) != null;
        }
        else return false;
    }

    public boolean isWin(){
        if (MoShi){
            return isTwoPlayerGreenWin() || isTwoPlayerRedWin();
        }
        else
            return isFourPlayerBlueWin() || isFourPlayerGreenWin() || isFourPlayerRedWin() || isFourPlayerYellowWin();
    }

    public boolean isTwoPlayerGreenWin(){
        int k=5;
        boolean a=true;
        for (int i=0;i<5;i++){
            if (i<2)
                k=5;
            else
                k--;
            for (int j=0;j<k;j++){
                if (!grid[i][j].getPiece().getColor().equals(Color.GREEN)){
                    a=false;
                    break;
                }
            }
            if (!a)
                break;
        }
        return a;
    }

    public boolean isTwoPlayerRedWin(){
        int k=5;
        boolean a=true;
        for (int i=1;i<6;i++){
            if (i<3)
                k=5;
            else
                k--;
            for (int j=1;j<k+1;j++){
                if (!grid[dimension-i][dimension-j].getPiece().getColor().equals(Color.RED)){
                    a=false;
                    break;
                }
            }
            if (!a)
                break;
        }
        return a;
    }

    public boolean isFourPlayerGreenWin(){
        int k=4;
        boolean a=true;
        for (int i=0;i<4;i++){
            if (i<2)
                k=4;
            else
                k--;
            for (int j=0;j<k;j++){
                if (!grid[i][j].getPiece().getColor().equals(Color.GREEN)){
                    a=false;
                    break;
                }
            }
            if (!a)
                break;
        }
        return a;
    }

    public boolean isFourPlayerRedWin(){
        int k=4;
        boolean a=true;
        for (int i=1;i<5;i++){
            if (i<3)
                k=4;
            else
                k--;
            for (int j=1;j<k+1;j++){
                if (!grid[dimension-i][dimension-j].getPiece().getColor().equals(Color.RED)){
                    a=false;
                    break;
                }
            }
            if (!a)
                break;
        }
        return a;
    }

    public boolean isFourPlayerBlueWin(){
        int k=4;
        boolean a=true;
        for (int i=0;i<4;i++){
            if (i<2)
                k=4;
            else
                k--;
            for (int j=1;j<k+1;j++){
                if (!grid[i][dimension-j].getPiece().getColor().equals(Color.BLUE)){
                    a=false;
                    break;
                }
            }
            if (!a)
                break;
        }
        return a;
    }

    public boolean isFourPlayerYellowWin(){
        int k=4;
        boolean a=true;
        for (int i=1;i<5;i++){
            if (i<3)
                k=4;
            else
                k--;
            for (int j=0;j<k;j++){
                if (!grid[dimension-i][j].getPiece().getColor().equals(Color.RED)){
                    a=false;
                    break;
                }
            }
            if (!a)
                break;
        }
        return a;
    }


    @Override
    public void registerListener(GameListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void unregisterListener(GameListener listener) {
        listenerList.remove(listener);
    }

    public void save() {
        String MOSHI;
        if (MoShi)
            MOSHI = "2PLAYER";
        else MOSHI = "4PLAYER";
        JFileChooser chooser = new JFileChooser("src/LOAD");
        chooser.showOpenDialog(null);
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {    //假如用户选择了保存
            File file = chooser.getSelectedFile();
            String fname = chooser.getName(file);    //从文件名输入框中获取文件名

            //假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀
            if (!fname.contains(".halma")) {
                file = new File(chooser.getCurrentDirectory(), fname + ".halma");
                System.out.println("renamed");
                System.out.println(file.getName());
            }

            PrintWriter save;
            try {
                save = new PrintWriter(file);
                Square[][] qipan = getGrid();
                save.println(MOSHI);
                save.println(getPlayer().getRGB());
                for (int i = 0; i < getDimension(); i++) {
                    for (int j = 0; j < getDimension(); j++) {
                        if (qipan[i][j].getPiece() != null) {
                            save.println(qipan[i][j].getPiece().getColor().getRGB() + "&" + i + "&" + j);
                        }
                    }
                }
                save.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
