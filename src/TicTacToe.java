import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //USER INPUTS FOR PLAYER DETAILS
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player1 name: ");
        String player1 = scanner.nextLine();
        System.out.println("Enter player2 name: ");
        String player2 = scanner.nextLine();

        //Initiate Game board
        Board board = new Board(player1, player2);
        boolean validMove = false;

        //Play Game
        while(!board.isGameOver()){
            if(validMove){
                board.nextPlayer();
            }
            board.viewBoard();
            System.out.println(board.getCurrentPLayer().getName() + ", Enter the x & y coordinates of your next move: ");
            validMove = board.updateBoard(board.getCurrentPLayer(), scanner.nextInt(), scanner.nextInt());
        }

        //Declare winner
        board.viewBoard();
        System.out.println("Game Over!!  Congratulations " + board.getCurrentPLayer().getName()
                + " (" + board.getCurrentPLayer().getSymbol() + ")" );

    }
}