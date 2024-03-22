import java.util.*;

class main {
	public static void main(String[] args){
		// Game g = new Game();
		// g.run();
		new p712();
	}
}
class p712 extends Program{
	public p712(){
		Invoice inv = new Invoice(); 
		while (true){
			print("Price: ");
			Double p = scan.nextDouble();
			if (p == -1){
				break;
			}
			print("Quantity: ");
			int q = scan.nextInt();
			print("Is it a pet?: ");
			boolean y = false;
			String pet = scan.next();
			if (pet.equals("y")) {
				// print("yay");
				y = true;
			}
			inv.add(new Item(p, y, q));
		}	
		print(inv.getDiscount());
	}
}

class Item{
	public double price;
	public boolean isPet;
	public int quantity;

	public Item(double price, boolean isPet, int quantity){
		this.price = price;
		this.isPet = isPet;
		this.quantity = quantity;
	}

    public String getUse(Game game) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUse'");
    }
}

class Invoice{
	private ArrayList<Item> items;
	public Invoice(){
		items = new ArrayList<Item>();
	}
	public void add(Item i){
		items.add(i);
	}
	public double getDiscount(){
		double discount = 0.0;
		int pets = 0;
		int misc = 0;
		for (Item x: items){
			if (x.isPet){
				pets++;
			} else {
				discount += 0.2*x.price;
				misc++;
			}
		}
		if (pets >= 1 && misc >= 5){
			return discount;
		} else {
			return 0;
		}
	}
}

class Game extends Program{
	private char[][] board;

	public Game(){
		board = new char[3][3];
	}
	public void run(){
		int move = 0;
		print("Insert your piece by typing in a number 1-9 like so \n", ANSI_PURPLE);
		printExampleBoard();
		while (!isFull()){
			printBoard();
			if (hasWon('O')){
				print("YAY YOU WON O", ANSI_YELLOW);
				break;
			}
			print("Your turn X> ");
			move = scan.nextInt();
			board[(move-1)/3][(move-1)%3] = 'X';
			printBoard();
			if (isFull()){
				break;
			}
			if (hasWon('X')){
				print("YAY YOU WON X", ANSI_YELLOW);
				break;
			}
			
			print("Your turn O> ");
			move = scan.nextInt();
			board[(move-1)/3][(move-1)%3] = 'O';
		}
		print("\nGame over");
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
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}

class Program {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public void print(String inp){
		System.out.print(inp);
	}
	public void print(String inp, String color){
		System.out.print(color + inp + ANSI_RESET);
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