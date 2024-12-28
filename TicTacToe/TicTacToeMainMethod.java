package OtherProjects.TicTacToeV5;

import java.util.Scanner;

public class TicTacToeMainMethod {
    public static void main(String[] args) {
        int size = 500;

        System.out.print("Choose board type 1 or 2: ");
        int type = new Scanner(System.in).nextInt();
        TicTacToeBoard game = new TicTacToeBoard(size, type);
        TicTacToeComputer computer = new TicTacToeComputer(game);

        while (GameState.getGameState(game.board) == 2) {
            if (game.turn) playerMove(game);
            else computer.move();
            game.turn = !game.turn;
        }
        game.gameOver();
        System.out.println(GameState.getEndGame(game.board));
    }

    public static void playerMove(TicTacToeBoard game) {
        int row, column;
        System.out.println("Player's move");
        System.out.print("Row: ");
        row = new Scanner(System.in).nextInt() -1;
        System.out.print("Column: ");
        column = new Scanner(System.in).nextInt() -1;
        while(game.checkMove(row,column)!=0) {
            if (game.checkMove(row, column) == -1) System.out.println("Square taken! ");
            else System.out.println("Move out of bounds! ");
            System.out.println("Choose another move");
            System.out.print("Row: ");
            row = new Scanner(System.in).nextInt() - 1;
            System.out.print("Column: ");
            column = new Scanner(System.in).nextInt() - 1;
        }
        game.makeMove(game.turn,row,column);
    }

}
