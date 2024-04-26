
/**
 * Write a description of class CSVReader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.util.stream.Stream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader
{
    List<List<String>> data;

    /**
     * Constructor for objects of class CSVReader
     */
    public CSVReader(String p) throws java.io.IOException,FileNotFoundException
    {
        data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(p))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); 
                List<String> oop = Arrays.asList(values);
                for (int i = 0; i < oop.size(); i++){
                    //if (p == "quotes.csv"){
                    //    System.out.print(oop.get(i).substring(0,1));
                    //}
                    if (oop.get(i).substring(0,1).equals("\"")){
                        oop.set(i, oop.get(i).substring(1, oop.get(i).length()-1));
                    }
                }
                data.add(oop);
            }
        }
    }
    public int numberOfRows(){
        return data.size();
    }
    public int numberOfFields(int i){
        return data.get(i).size();
    }
    public String getField(int r, int c){
        return data.get(r).get(c);
    }
}
