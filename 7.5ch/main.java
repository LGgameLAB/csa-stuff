import java.util.*;

class main {
	public static void main(String[] args){
		char[][] board = new char[3][3];
		System.out.print(board[0][0] == 0);
		Game g = new Game();
		g.run();
	}
}

class Game extends Program{
	private char[][] board;
	public Game(){
		board = new char[3][3];
	}
	public void run(){
		int move = 0;
		print("insert your piece by typing in a number 1-9 like so \n");
		printExampleBoard();
		while (!isFull()){
			printBoard();
			if (hasWon('O')){
				print("YAY YOU WON o");
				break;
			}
			print("Your turn X> ");
			move = scan.nextInt();
			board[(move-1)/3][(move-1)%3] = 'X';
			printBoard();
			if (hasWon('X')){
				print("YAY YOU WON X");
				break;
			}
			
			print("Your turn O> ");
			move = scan.nextInt();
			board[(move-1)/3][(move-1)%3] = 'O';
		}
		print("Game over");
	}
	public void printExampleBoard(){
		int a = 1;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				print(a);
				a++;
			}
			print("\n");
		}
	}
	public void printBoard(){
		print("\n _______Current Board______ \n \n");
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (board[i][j] == 0){
					print("-");
				} else {
					print(String.valueOf(board[i][j]));
				}
			}
			print("\n");
		}
	}
	private boolean hasWon(char p){
		// check rows
		for (int i = 0; i < 3; i++){
			if (board[i][0] == p && board[i][1] == p && board[i][2] == p){
				return true;
			}
		}
		// check columns
		for (int i = 0; i < 3; i++){
			if (board[0][i] == p && board[1][i] == p && board[2][i] == p){
				return true;
			}
		}
		//check diagonals
		if (board[0][0] == p && board[1][1] == p && board[2][2] == p){
			return true;
		}
		if (board[0][2] == p && board[1][1] == p && board[2][0] == p){
			return true;
		}
		return false;
	}

	private boolean isFull(){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (board[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
}

class Program {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	public void print(String inp){
		System.out.print(inp);
	}
	public void print(int inp){
		System.out.print(inp);
	}
	public void print(float inp){
		System.out.print(inp);
	}
	public void print(Double inp){
		System.out.print(inp);
	}
}