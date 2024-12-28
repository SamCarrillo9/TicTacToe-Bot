package OtherProjects.TicTacToeV5;

import java.awt.*;
import java.util.Random;


class TicTacToeBoard {
    String[][] board;
    int[][] coordinate = {{1,2,3},{4,5,6},{7,8,9}};
    boolean turn;

    BoardCanvas boardCanvas;
    DrawingPanel canvas;
    Graphics pen;
    TicTacToeBoard(int size, int type){
        boardCanvas = new BoardCanvas(size, type);
        canvas = boardCanvas.boardType;
        pen = boardCanvas.pen;
        board = new String[][] {{" "," "," "},{" "," "," "},{" "," "," "}};
        turn = new Random().nextBoolean();
    }
    // returns 0 if the game is not over, 1 if there is a tie, 2 if the game has been won
    public void gameOver (){
        //check for tie
        boolean tie = true;
        for(String[] s : board)
            for(String square : s)
                if (square.equals(" ")) tie = false;
        if(!tie) {
            //check for horizontal or vertical three in a row
            for (int i = 0; i < 3; i++) {
                // compares the first square of a row or column to the rest of the squares in the row or column
                String rowReference = board[i][0];
                String columnReference = board[0][i];
                //check first if the square isn't empty, otherwise three
                // empty squares in a row would return as a win
                if (!rowReference.equals(" "))
                    if (board[i][1].equals(rowReference) && board[i][2].equals(rowReference)) {
                        drawWinLine(pen, i, 1);
                    }
                if (!columnReference.equals(" "))
                    if (board[1][i].equals(columnReference) && board[2][i].equals(columnReference)) {
                        drawWinLine(pen, i, 2);
                    }

            }
            //check for diagonal three in a row starting from the top left
            if (!board[1][1].equals(" ") && board[1][1].equals(board[0][0]) && board[1][1].equals(board[2][2])) {
                drawWinLine(pen, 0, 3);
            }
            //check for diagonal three in a row starting from the bottom left
            if (!board[1][1].equals(" ") && board[1][1].equals(board[2][0]) && board[1][1].equals(board[0][2])) {
                drawWinLine(pen, 2, 4);
            }
        }
    }
    //returns -1 if the square is taken, 0 if the square is empty, 1 if the move is out of bounds
    public int checkMove(int row, int column){
        if ((row < 0 || row >= 3) || (column < 0 || column >= 3)) return 1;
        if (!board[row][column].equals(" ")) return -1;
        return 0;
    }
    public void makeMove(Boolean turn, int r, int c){
        if (turn) board[r][c] = "X";
        else board[r][c] = "O";

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if(board[row][column].equals("X") ) drawX(row, column);
                else if(board[row][column].equals("O") ) drawO(row, column);
            }
        }
    }
    void drawX(int row, int column){
        int x = 12 + column * 166;
        int y = 12 + row * 166;
        int n = x;
        for (int i = y; i <= y + 124; i+=2){
            pen.fillOval(n,i,16,16);
            n+=2;
        }
        n = x;
        for (int i = y + 124; i >= y; i -= 2){
            pen.fillOval(n,i,16,16);
            n+=2;
        }
    }
    void drawO (int row, int column) {
        int centerX = 83 + column * 166;
        int centerY = 83 + row * 166;
        int radius = 62;

        for (int y = centerY - radius; y <= centerY + radius; y++) {
            int x = (int) (centerX + Math.sqrt(radius * radius - (y - centerY) * (y - centerY) ) );
            if (x!=0) pen.fillOval(x-7, y-7, 14, 14);
        }

        for (int y = centerY - radius; y <= centerY + radius; y++) {
            int x = (int) (centerX - Math.sqrt(radius * radius - (y - centerY) * (y - centerY) ) );
            if (x!=0) pen.fillOval(x-7, y-7, 14, 14);
        }

        for (int x = centerX - radius; x <= centerX + radius; x++) {
            int y = (int) (centerY + Math.sqrt(radius * radius - (x - centerX) * (x - centerX) ) );
            if (y!=0) pen.fillOval(x-7, y-7, 14, 14);
        }
        for (int x = centerX - radius; x <= centerX + radius; x++) {
            int y = (int) (centerY - Math.sqrt(radius * radius - (x - centerX) * (x - centerX) ) );
            if (y!=0) pen.fillOval(x-7, y-7, 14, 14);
        }

    }
    public static void drawWinLine(Graphics pen, int i, int winType){
        Color winRed = new Color(235, 64, 52);
        pen.setColor(winRed);
        if (winType == 1){
            pen.fillOval(7, 74 + i * 166, 21,21);
            pen.fillRect(15, 74 + i * 166, 469, 21);
            pen.fillOval(472,74 + i * 166, 21,21);
        }
        else if (winType == 2){
            pen.fillOval(74 + i * 166, 7, 21, 21);
            pen.fillRect(74 + i * 166, 15 , 21, 469);
            pen.fillOval(74 + i * 166, 472, 21, 21);
        }
        else if (winType == 3)
            for (int n = 28; n <= 448; n+=2)
                pen.fillOval(n,n,21,21);

        else if (winType == 4){
            int s = 448;
            for (int n = 28; n <= 452; n += 2){
                pen.fillOval(n,s,21,21);
                s-=2;
            }
        }
        Color XsAndOsBlackBrown = new Color(18, 5, 7);
        pen.setColor(XsAndOsBlackBrown);
    }
}
