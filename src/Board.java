
public class Board {
    private int row = 3;
    private int col = 3;
    private char[][] board;
    private Player player1 = null;
    private Player player2 = null;
    private Player currentPlayer = null;

    Board(String player1, String player2){
        //Initialize board
        this.board = new char[3][3];
        for(int rowIndex=0; rowIndex < row; rowIndex++){
            for(int colIndex=0; colIndex < col; colIndex++){
                this.board[rowIndex][colIndex] = ' ';
            }
        }
        //add players
        addPlayer(player1, player2);
    }

    public char[][] getBoard(){
        return this.board;
    }

    public Player getCurrentPLayer(){
        return this.currentPlayer;
    }

    private void addPlayer(String player1, String player2){
        if(this.player1 == null && this.player2 == null){
            this.player1 = new Player(1, player1, 'X');
            this.player2 = new Player(2, player2, 'O');
            this.currentPlayer = this.player1;
        } else{
            System.out.println("Player Can't be added. Max of 2 players can only play this game !!");
        }
    }

/*    public void viewBoard(){
        for(int colIndex=0; colIndex < this.col; colIndex++){
            System.out.print("_____");
        }
        System.out.println();
        for(int rowIndex=0; rowIndex < this.row; rowIndex++){
            System.out.print(" | ");
            for(int colIndex=0; colIndex < this.col; colIndex++){
                System.out.print(this.board[rowIndex][colIndex] + " | ");
            }
            System.out.println();
            for(int colIndex=0; colIndex < this.col; colIndex++){
                System.out.print("_____");
            }
            System.out.println();
        }
    }*/

    public void viewBoard(){
        for(int rowIndex=0; rowIndex < this.row; rowIndex++){
            for(int colIndex=0; colIndex < this.col; colIndex++){
                if(colIndex==0){
                    System.out.print(" | ");
                }
                System.out.print(this.board[rowIndex][colIndex] + " | ");
            }
            System.out.println();
        }
    }

    public boolean updateBoard(Player player, int x_coordinate, int y_coordinate){
        if (x_coordinate < row && y_coordinate < col) {
            if (this.board[x_coordinate][y_coordinate] == ' ') {
                this.board[x_coordinate][y_coordinate] = player.getSymbol();
                return true;
            } else {
                System.out.println("Invalid Input. Try Again!!");
                return false;
            }
        } else {
            System.out.println("Invalid Input. Try Again!!");
            return false;
        }
    }

    public void nextPlayer(){
        if(this.currentPlayer.getName().equals(this.player1.getName())){
            this.currentPlayer =  this.player2;
        } else {
            this.currentPlayer =  this.player1;
        }
    }

    public boolean isGameOver(){
        for(int row=0; row<3; row++) {
            if (this.board[row][0] != ' ' && (this.board[row][0] == this.board[row][1]) && (this.board[row][1] == this.board[row][2])) {
                return true;
            }
        }
        for(int col=0; col<3; col++) {
            if (this.board[0][col] != ' ' && (this.board[0][col] == this.board[1][col]) && (this.board[1][col] == this.board[2][col])) {
                return true;
            }
        }
        if (this.board[0][0] != ' ' && (this.board[0][0] == this.board[1][1]) && (this.board[1][1] == this.board[2][2])) {
            return true;
        }
        if (this.board[0][2] != ' ' && (this.board[0][2] == this.board[1][1]) && (this.board[1][1] == this.board[2][0])) {
            return true;
        }
        return false;
    }
}
