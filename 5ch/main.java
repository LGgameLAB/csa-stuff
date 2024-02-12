import java.util.*;

class main {
	public static void main(String[] args){
		// e57 yay = new e57();
		// e510 yay = new e510();
		// GradeTester yay = new GradeTester();
		CardTesterE516 yay = new CardTesterE516();
		// System.out.print(new Card("10C").getDescription());
	}
}
class CardTesterE516 {
   public CardTesterE516(){      
      System.out.println("4S: " + new Card("4S").getDescription());
      System.out.println("Expected: Four of Spades");  
      System.out.println("CQ: " + new Card("QC").getDescription());
      System.out.println("Expected: Queen of Clubs");  
      System.out.println("AD: " + new Card("AD").getDescription());
      System.out.println("Expected: Ace of Diamonds");  
      System.out.println("10S:" + new Card("10S").getDescription());
      System.out.println("Expected: Ten of Spades");  
      System.out.println("CA: " + new Card("CA").getDescription());
      System.out.println("Expected: Unknown");  
      System.out.println(":   " + new Card("").getDescription());
      System.out.println("Expected: Unknown");  
      System.out.println("?:  " + new Card("?").getDescription());
      System.out.println("Expected: Unknown");  
   }
}
class Card {
	private String code;
	public Card(String c){
		code = c;
	}
	public String getDescription(){
		String r = "";
		if (code.length() < 2){
			return "unknown";
		}
		switch (code.substring(0, 1)) {
			case "A": r = "Ace"; break;
			case "2": r = "Two"; break;
			case "3": r = "Three"; break;
			case "4": r = "Four"; break;
			case "5": r = "Five"; break;
			case "6": r = "Six"; break;
			case "7": r = "Seven"; break;
			case "8": r = "Eight"; break;
			case "9": r = "Nine"; break;
			case "1": r = "Ten"; break;
			case "Q": r = "Queen"; break;
			case "K": r = "King"; break;
			case "J": r = "Jack"; break;
			default: r = "unknown"; break;
		}
		if (r.equals("unknown")){
			return r;
		}
		r = r + " of ";
		switch (code.substring(code.length()-1)) {
			case "S": r = r + "Spades"; break;
			case "D": r = r + "Diamonds"; break;
			case "H": r = r + "Hearts"; break;
			case "C": r = r + "Clubs"; break;
		}
		return r;
	}
}
class Program {
	Scanner scanz = new Scanner(System.in);
	public void print(String inp){
		System.out.println(inp);
	}
}
class GradeTester
{
   public GradeTester()
   {
      System.out.println("A:  " + new Grade("A").getNumericGrade());
      System.out.println("Expected: 4");
      System.out.println("A+: " + new Grade("A+").getNumericGrade());
      System.out.println("Expected: 4");
      System.out.println("A-: " + new Grade("A-").getNumericGrade());
      System.out.println("Expected: 3.7");
      System.out.println("C:  " + new Grade("C").getNumericGrade());
      System.out.println("Expected: 2");
      System.out.println("C+: " + new Grade("C+").getNumericGrade());
      System.out.println("Expected: 2.3");
      System.out.println("C-: " + new Grade("C-").getNumericGrade());
      System.out.println("Expected: 1.7");
      System.out.println("F:  " + new Grade("F").getNumericGrade());
      System.out.println("Expected: 0");
  }
}
class Grade{
	private String grade;
	public Grade(String g){
		grade = g;
	}
	public double getNumericGrade(){
		double score = 0;
		if (grade.substring(0,1).equals("A")){
			score = 4;
		} else if (grade.substring(0,1).equals("B")){
			score = 3;
		} else if (grade.substring(0,1).equals("C")){
			score = 2;
		} else if (grade.substring(0,1).equals("D")){
			score = 1;
		}
		if (grade.length() > 1){
			if (grade.substring(1,2).equals("-")){
				score -= 0.3;
			} else {
				score += 0.3;
			}
		}
		return Math.max(0, Math.min(score, 4.0));
	}
}
class e510 extends Program {
	public e510(){
		print("Please enter the first number: ");
		int num1 = scanz.nextInt();
		print("The second number: ");
		int num2 = scanz.nextInt();
		print("The third number: ");
		int num3 = scanz.nextInt();
		print("The fourth number: ");
		int num4 = scanz.nextInt();
		List<Integer> list = Arrays.asList(num1, num2, num3, num4); 
 
        if (list.stream().distinct().count() == 2){
        	print("TWO PAIRS!");
        } else {
        	print("dumbass");
        }
	}
}
class e57 extends Program {
	public e57(){
		print("Please enter the first number: ");
		int num1 = scanz.nextInt();
		print("The second number: ");
		int num2 = scanz.nextInt();
		print("The third number: ");
		int num3 = scanz.nextInt();

		if (num2 - num1 > 0) {
			if (num3 - num2 > 0) {
				print("increasing");
			} else {
				print("neither");
			}
		} else {
			if (num3 - num2 < 0) {
				print("decreasing");
			} else {
				print("neither");
			}
		}
	}
}