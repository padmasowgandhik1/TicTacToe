
public class Board {
    int row = 3;
    int col = 3;
    char[][] board;
    Player player1 = null;
    Player player2 = null;

    Board(){
        this.board = new char[3][3];
        for(int rowIndex=0; rowIndex < row; rowIndex++){
            for(int colIndex=0; colIndex < col; colIndex++){
                this.board[rowIndex][colIndex] = ' ';
            }
        }
    }

    public char[][] getBoard(){
        return this.board;
    }

    public void addPlayer(String player1, String player2){
        if(this.player1 == null && this.player2 == null){
            this.player1 = new Player(1, player1, 'X');
            this.player2 = new Player(2, player2, 'O');
        } else{
            System.out.println("Player Can't be added. Max of 2 players can only play this game !!");
        }
    }

    public void viewBoard(){
        for(int rowIndex=0; rowIndex < this.row; rowIndex++){
            for(int colIndex=0; colIndex < this.col; colIndex++){
                System.out.print(this.board[rowIndex][colIndex] + " | ");
            }
            System.out.println();
        }
    }

    public void updateBoard(Player player, int x_coordinate, int y_coordinate){
        if (x_coordinate < row || y_coordinate < col) {
            if (this.board[x_coordinate][y_coordinate] == ' ') {
                this.board[x_coordinate][y_coordinate] = player.getSymbol();
            } else {
                System.out.println("Invalid Input. Try Again!!");
            }
        } else {
            System.out.println("Invalid Input. Try Again!!");
        }
    }

    public Player nextPlayer(Player player){
        if(player.getName().equals(this.player1.getName())){
            return this.player2;
        } else {
            return this.player1;
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
