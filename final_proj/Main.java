import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StateReader reader = null;
        while (reader == null){
            print("Please enter a state abbreviation> ");
            String inp = "STATE." + in.next().toUpperCase() +".TXT";
            System.out.println("Loading " + inp);
            try{reader = new StateReader(inp);} catch (FileNotFoundException e1 ){
                println("\nThat state was not valid, please try again");
            }
        }
        String output = "";
        while (output.equals("")){
            print("\nPlease enter a year> ");
            String year = in.next();
            print("\nPlease enter a sex (m/f)> ");
            String sex = in.next();
            try{
                output = reader.queryMostCommon(year, sex);
            } catch (Exception d1){
                System.out.print("Sex or year not valid");
            }
        }
        println(output);
        
    }
    public static void println(String a){
        System.out.println(a);
    }
    public static void print(String a){
        System.out.print(a);
    }
}

class StateReader{
    private File file;
    private Scanner in;
    private ArrayList<String[]> data;
    public StateReader(String filename) throws java.io.FileNotFoundException{
        file = new File(filename);
        in = new Scanner(file).useDelimiter("\n");
        data = new ArrayList<String[]>();
        while (in.hasNext()){
            String[] line = in.next().split(",",0);
            data.add(line);
        }
        // System.out.println(Integer.valueOf(data.get(0)[4].substring(0, data.get(0)[4].length()-1)));
    }
    public String queryMostCommon(String year, String sex){
        int cnt = 0;
        int sum = 0; //Used to tell what percent of babies had name..
        int entry = 0;
        int max = 0;
        for (String[] i: data){
            if (i[2].equals(year) && i[1].equals(sex.toUpperCase())){
                int val = Integer.valueOf(i[4].substring(0, i[4].length()-1));
                if (val>max){
                    entry = cnt;
                    max = val;
                }
                sum += val;
            }
            cnt++;
        }
        String gender = sex.equals("f")? "female": "male";
        String finalCount = data.get(entry)[4].substring(0, data.get(entry)[4].length()-1);
        System.out.print(sum);
        int percent = Integer.valueOf(finalCount)/(sum/100);
        return "\nThe most popular " + gender + " name in " + 
            year + " was " + data.get(entry)[3] + " which made up " + percent + " percent of births (" + finalCount + " births)";
    }
}
