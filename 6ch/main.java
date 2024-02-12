import java.util.*;

class main {
	public static void main(String[] args){
		// e61d yay = new e61d();
		// e61e yay = new e61e();
		// e63a yay = new e63a();
		// e63c yay = new e63c();
		// e66 yay = new e66();
		// p66 yay = new p66();
		p69 yay = new p69();
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

class e61d extends Program {
	public e61d(){
		print("What is lower bound?");
		// System.out.print("WTF");
		int a = scan.nextInt();
		print("What is upper bound?");
		int b = scan.nextInt();
		for (int i = a; i <=b; i += 2){
			if (i % 2 == 0){
				i += 1;
			}
			print(i);
		}
	}
}

class e61e extends Program {
	public e61e(){
		print("Give me a number");
		String num = scan.nextLine();
		int sum = 0;
		int current = 0;
		for (int i = 0; i < num.length(); i++){
			current = Character.getNumericValue(num.charAt(i));
			if (current % 2 != 0){
				sum += current;
			}
		}
		print(sum);
	}
}

class e63a extends Program {
	public e63a(){
		print("Gimme a string");
		String in = scan.nextLine();
		for (int i = 0; i < in.length(); i++){
			char c = in.charAt(i);
			if (Character.isUpperCase(c)){
				print(Character.toString(c));
			}
		}
	}
}

class e63c extends Program {
	public e63c(){
		print("Gimme a string boyo");
		String s = scan.nextLine();
		System.out.print(s.replaceAll("[AEIOUaeiou]", "_"));
	}
}

class e66 extends Program {
	public e66 () {
		double m = 99999999;
		while (scan.hasNextDouble()){
			m = Math.min(scan.nextDouble(), m);
		}
		print(m);
	}
}

class p66 extends Program {
	public p66 (){
		int x = 0;
		int y = 0;
		for (int i = 0; i < 100; i++){
			int n = rand.nextInt(4);
			if (n > 1) {
				x += -1 + 2*(n % 2);
			} else {
				y += -1 + 2*(n % 2);
			}
		}
		print("(" + x + ", " + y + ")");
	}
}
class p69 extends Program {
	public p69() {
		// Game 1
		int wins = 0;
		int losses = 0;
		for (int i=0; i < 1000000;i++) {
			if (game1()){
				wins++;
			} else {
				losses++;
			}
		}
		print("Game 1 (with 4 dice rolls)\nLosses - " + losses + "\n" + "Wins - " + wins);
		wins = 0;
		losses = 0;
		for (int i=0; i < 1000000;i++) {
			if (game2()){
				wins++;
			} else {
				losses++;
			}
		}
		print("Game 2 (with 24 dice rolls)\nLosses - " + losses + "\n" + "Wins - " + wins);
	}
	public boolean game1(){
		for (int i=0; i < 4;i++) {
			if (dieRoll() == 6){
				return true;
			}
		}
		return false;
	}
	public boolean game2(){
		for (int i=0; i < 24;i++) {
			if (dieRoll() == 6){
				if (dieRoll() == 6){
					return true;
				}
			}
		}
		return false;
	}
	public int dieRoll(){
		return rand.nextInt(6) + 1;
	}
}