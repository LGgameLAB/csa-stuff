import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CoinReader{
    public CoinReader() throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.print("\n\nPlease Enter a File Name> ");
        try {
            System.out.println("\n" + Coin.sum(Coin.readFile(scan.next())));
        } catch (FileNotFoundException e){
            System.out.println("file not found silly");
            System.out.print("\n\nPlease Enter Another a File Name> ");
            try {
                System.out.println("\n" + Coin.sum(Coin.readFile(scan.next())));
            } catch (FileNotFoundException d){
                System.out.println("file not found silly");
            } 
        } 
        
    }
}
