package OtherProjects.TicTacToeV5;

import java.util.Arrays;

public class TicTacToeComputer {
    TicTacToeBoard game;

    TicTacToeComputer(TicTacToeBoard game){
        this.game = game;
    }
    public void move(){
        int bestRow = 0;
        int bestColumn = 0;
        int max = -1;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if(checkMove(game.board,row,column) == 0) {
                    String[][] copy = copyBoard(game.board);
                    makeMove(copy, false, row, column);
                    int result = min(copy);
                    if (result >= max) {
                        max = result;
                        bestRow = row;
                        bestColumn = column;
                    }
                }
            }
        }
        game.makeMove(false, bestRow,bestColumn);
    }
    public int max(String[][] board) {
        if (GameState.getGameState(board) != 2) return GameState.getGameState(board);
        else {
            int max = -1;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (checkMove(board, row, column) == 0) {
                        String[][] copy = copyBoard(board);
                        makeMove(copy, false, row, column);
                        int result = min(copy);
                        if(result == 1) return result;
                        else if(result >= max) max = result;
                    }
                }
            }
            return max;
        }
    }
    public int min(String[][] board) {
        if (GameState.getGameState(board) != 2) return GameState.getGameState(board);
        else {
            int min = 1;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (checkMove(board, row, column) == 0) {
                        String[][] copy = copyBoard(board);
                        makeMove(copy, true, row, column);
                        int result = max(copy);
                        if(result == -1) return result;
                        else if(result <= min) min = result;
                    }
                }
            }
            return min;
        }
    }
    //returns -1 if the square is taken, 0 if the square is empty, 1 if the move is out of bounds
    public int checkMove(String[][] board, int row, int column){
        if ((row < 0 || row >= 3) || (column < 0 || column >= 3)) return 1;
        if (!board[row][column].equals(" ")) return -1;
        return 0;
    }
    public void makeMove(String[][] board, Boolean turn, int row, int column){
        if (turn) board[row][column] = "X";
        else board[row][column] = "O";
    }
    public String[][] copyBoard(String[][] board){
        String[][] copy = new String[3][];
        for (int i = 0; i < 3; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copy;
    }
}
