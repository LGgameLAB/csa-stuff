import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
/**
 * The Horrifying game of ZUUL
 * A tale of mystery set in the expanse of the universe
 * 
 * 
 * @author Luke Gonsalves
 * @version 1.0
 */
public class Main
{
   public static void main( String[] args ) throws IOException {
        System.out.println(new String(Files.readAllBytes(Paths.get("csa-stuff/zuul/endscreen.txt"))));
        Game game = new Game(); 
        game.play();
    
    }
} 