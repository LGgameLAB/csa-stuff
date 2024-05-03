import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Coin {
    private double value;
    private String name;
    public Coin(String name, double value){
        this.value = value;
        this.name = name;
    }
    public double getValue(){
        return value;
    }
    public String getName(){
        return name;
    }
    public static Double sum(ArrayList<Coin> cs){
        Double total = 0.0;
        for (Coin c : cs){
            total += c.getValue();
        }
        return total;
    }
    public static ArrayList<Coin> readFile(String filename) throws FileNotFoundException{
        ArrayList<Coin> out = new ArrayList<Coin>();
        Scanner in = new Scanner(new File(filename)).useDelimiter("\n");
        while (in.hasNext()){
            Scanner s2 = new Scanner(in.next());
            try {
                // System.out.print(s2.next());
                out.add(new Coin(s2.next(), s2.nextDouble()));
            } catch (InputMismatchException e){
                System.out.println("This data is fudged dude");
            }
        }
        return out;
    }
}
