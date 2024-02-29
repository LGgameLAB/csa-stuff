import java.util.*;

class main {
	public static void main(String[] args){
		new p75();
	}
}


class Program {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	public void print(String inp){
		System.out.println(inp);
	}
	public void print(int inp){
		System.out.println(inp);
	}
	public void print(float inp){
		System.out.println(inp);
	}
	public void print(Double inp){
		System.out.println(inp);
	}
}
class p75 {
	public p75(){
	Piles deck = new Piles(new int[]{ 20, 5, 1, 9, 10 });
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [19, 4, 8, 9, 5]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [18, 3, 7, 8, 4, 5]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [17, 2, 6, 7, 3, 4, 6]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [16, 1, 5, 6, 2, 3, 5, 7]");      
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [15, 4, 5, 1, 2, 4, 6, 8]");
      deck.playRound();
      System.out.println(deck);
      System.out.println("Expected: [14, 3, 4, 1, 3, 5, 7, 8]");  
	}
}
class Piles {
	int[] deck;
	public Piles(int[] d){
		deck = d;
	}
	public void playRound(){
		int j = 1;
		if (Arrays.binarySearch(deck, 1) > 0){
			j=0;
		}
		int[] newdeck = new int[deck.length+j];
		j=0;
		for (int i = 0; i < deck.length; i++){
			if (deck[i]-1 == 0){
				j++;
			} else {
				newdeck[i-j] = deck[i]-1;
			}
		}
		newdeck[newdeck.length-1] = deck.length;
		deck = newdeck;
 	}
 	public String toString(){
 		return Arrays.toString(deck);
 	}
}
class p74 extends Program {
	public p74(){
		int STALLS = 12;
      Restroom wc = new Restroom(STALLS);
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: ______X_____");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: ___X__X_____");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: ___X__X__X__");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: _X_X__X__X__");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: _X_X_XX__X__");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: _X_X_XX_XX__");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: _X_X_XX_XX_X");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: XX_X_XX_XX_X");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: XXXX_XX_XX_X");
	}
}
class Restroom extends Program {
	private String diagram;
	private int stalls;
	public Restroom (int s) {
		stalls = s;
		diagram = new String(new char[s]).replace('\0', '_');
	}
	public String getStalls(){
		return diagram;
	}
	public void addOccupant(){
		String lastcharacter = diagram.substring(diagram.length()-1, diagram.length());
		String[] yay = diagram.split("X", 0);
		int bestIndex = 0; 
		for (int i=0; i < yay.length; i++){
			if (yay[i].length() > yay[bestIndex].length()){
				bestIndex = i;
			}
		}
		yay[bestIndex] = replaceInd(yay[bestIndex], 'X', roundUp(yay[bestIndex].length()/2) );

		diagram = "";
		for (int i=0; i < yay.length; i++){
				diagram += yay[i] + "X";
		}
		if (diagram.length() > stalls){
			diagram = diagram.substring(0, diagram.length()-1);
		}
	}
	public String replaceInd(String str, char ch, int index){
		return str.substring(0, index) + ch
              + str.substring(index + 1);
	}
	public int roundUp(double n){
		return (int) Math.ceil(n);
	}

}
