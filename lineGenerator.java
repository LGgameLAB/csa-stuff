
/**
 * Write a description of class lineGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.File;
import java.io.PrintWriter;

public class lineGenerator
{


    /**
     * Constructor for objects of class lineGenerator
     */
    public static void main(String[] args) throws java.io.FileNotFoundException
    {   
        Scanner scan0 = new Scanner(System.in);
        System.out.print("What file would you like to output to?: ");
        String d = scan0.next();
        Scanner scan = new Scanner(new File("code.java")).useDelimiter("\n");
        PrintWriter out = new PrintWriter(d);
        int x = 1;
        while (scan.hasNext()){
            out.println("/* " + x + " */ " +scan.next());   
            x++;
        }
        out.close();
        System.out.println("done");
    }
}
