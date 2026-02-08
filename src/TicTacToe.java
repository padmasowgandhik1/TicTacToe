import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //USER INPUTS FOR PLAYER DETAILS
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player1 name: ");
        String player1 = scanner.nextLine();
        System.out.println(player1);
        System.out.println("Enter player2 name: ");
        String player2 = scanner.nextLine();
        System.out.println(player2);

        //Initiate Game board
        Board board = new Board();
        board.addPlayer(player1, player2);

        //Play Game
        Player currentPlayer = board.player2;
        System.out.println(currentPlayer);
        while(!board.isGameOver()){
            currentPlayer = board.nextPlayer(currentPlayer);
            System.out.println(currentPlayer);
            board.viewBoard();
            System.out.println(currentPlayer.getName() + ", Enter the x & y coordinates of your next move: ");
            board.updateBoard(currentPlayer, scanner.nextInt(), scanner.nextInt());
        }

        //Decalare winner
        System.out.println("Game Over!!  Congratulations " + currentPlayer.getName() );

    }
}