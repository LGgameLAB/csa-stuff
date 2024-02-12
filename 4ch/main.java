import java.util.Scanner;

class main {
    public static void main(String[] args){
        // e49 yay = new e49();
        // e411 yay = new e411();
        // e415 yay = new e415();
        // e416 yay = new e416();
    }
}

class Program {
    protected Scanner scanz = new Scanner(System.in); 
}

class e416 extends Program {
    public e416(){
        System.out.println("Please enter the first time: ");
        int t1 = scanz.nextInt();
        System.out.println("Please enter the second time: ");
        int t2 = scanz.nextInt();
        int t1Minutes = t1 / 100 * 60 + t1 % 100;
        int t2Minutes = t2 / 100 * 60 + t2 % 100;
        // Fits the time into 0-24 hour interval
        int diff = (24*60 + t2Minutes - t1Minutes) % (24 * 60);
        System.out.println("Hours: " + (diff / 60));
        System.out.println("Minutes: " + (diff % 60));//( ( (float)diff / 60 ) - diff/60)*60 );
    }
}

class e415 extends Program {
    public e415(){
        System.out.println("Please enter a number: ");
        int num = scanz.nextInt();
        System.out.print((num / 10000) % 10);
        System.out.print(' ');
        System.out.print((num / 1000) % 10);
        System.out.print(' ');
        System.out.print((num / 100) % 10);
        System.out.print(' ');
        System.out.print((num / 10) % 10);
        System.out.print(' ');
        System.out.print(num % 10);
    }
}
class e411 {
    public e411() {
        Scanner scanz = new Scanner(System.in);
        System.out.println("Please enter a drive letter: ");
        String drive = scanz.nextLine();
        System.out.println("Please enter a path: ");
        String path = scanz.nextLine();
        System.out.println("Please enter a file: ");
        String file = scanz.nextLine();
        System.out.println("Please enter a file extension: ");
        String extension = scanz.nextLine();

        System.out.println("\n" + drive + ':' + path + file + extension);
    }
}

class e49 {
    private Scanner scanz;
    private float gallons;
    private float fuelEfficiency;
    private float ppg;
    
    public e49(){
        this.scanz = new Scanner(System.in);
        this.run();
    }
    public void run(){
        System.out.println("How many gallons of fuel are in the tank?");
        this.gallons = scanz.nextFloat();
        System.out.println("What is the fuel efficiency (miles per gallon)");
        this.fuelEfficiency = scanz.nextFloat();
        System.out.println("What is the price of gas");
        this.ppg = scanz.nextFloat();

        System.out.println("\n Cost to travel 100 miles: " + Float.toString((100/fuelEfficiency) * ppg));
        System.out.println("\n Can travel " + Float.toString(fuelEfficiency * gallons) + "miles");
    }
}   
