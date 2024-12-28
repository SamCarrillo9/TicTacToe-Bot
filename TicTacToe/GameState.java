package OtherProjects.TicTacToeV5;

public class GameState {

    // returns -1 if the player (X's) has won, 0 if there is a tie,
    // 1 if the computer (O's) has won, and 2 if the game is not over
    public static int getGameState(String[][] board){
        //check for tie
        boolean tie = true;
        for(String[] s : board)
            for(String square : s)
                if (square.equals(" ")) tie = false;
        if(tie) return 0;
        //check for horizontal or vertical three in a row
        for (int i = 0; i < 3; i++) {
            // compares the first square of a row or column to the rest of the squares in the row or column
            String rowReference = board[i][0];
            String columnReference = board[0][i];
            //check first if the square isn't empty, otherwise three
            // empty squares in a row would return as a win
            if(!rowReference.equals(" "))
                if (board[i][1].equals(rowReference) && board[i][2].equals(rowReference))
                    return getWinner(rowReference);
            if(!columnReference.equals(" "))
                if (board[1][i].equals(columnReference) && board[2][i].equals(columnReference))
                    return getWinner(columnReference);
        }
        //check for diagonal three in a row starting from the top left
        if ( !board[1][1].equals(" ") && board[1][1].equals(board[0][0]) && board[1][1].equals(board[2][2]) )
            return getWinner(board[1][1]);
        //check for diagonal three in a row starting from the bottom left
        if ( !board[1][1].equals(" ") && board[1][1].equals(board[2][0]) && board[1][1].equals(board[0][2]) )
            return getWinner(board[1][1]);
        return 2;
    }
    private static int getWinner(String winner){
        if(winner.equals("X")) return -1;
        else return 1;
    }
    public static String getEndGame(String[][] board){
        int result = getGameState(board);
        if (result == -1) return "Player Wins!";
        else if(result == 0) return "It's a tie!";
        else return "Computer Wins!";
    }
}
