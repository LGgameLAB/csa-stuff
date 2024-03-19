/**
   A test for the ZIPtoBarCode class.
*/
public class Main
{
   public static void main(String[] args)
   {
    //   System.out.println(ZIPtoBarCode.decToBinary(9));
      System.out.println("ZIP code: 95014");
      int[] inputCode = new int[] { 9, 5, 0, 1, 4 };
      System.out.println("Barcode : " + ZIPtoBarCode.convertZIP(inputCode));
      System.out.println("Expected: ||:|:::|:|:||::::::||:|::|:::|||");

      System.out.println("");

      System.out.println("Barcode : ||:|:::|:|:||::::::||:|::|:::|||");
      int[] outputCode = ZIPtoBarCode
            .convertBarcode("||:|:::|:|:||::::::||:|::|:::|||");
      System.out.println("ZIP code: " + outputCode[0] + outputCode[1]
            + outputCode[2] + outputCode[3] + outputCode[4]);
      System.out.println("Expected: 95014");
   }
   
}

public class ZIPtoBarCode{
    public static final int BITS = 4;
    // public static String decToBinary(int n){
    //     String retr = "";
    //     for (int i = BITS-1; i >= 0; i--){
    //         int k = n >> i;
    //         if ((k & 1) > 0){
    //             retr += 1;
    //         } else {
    //             retr += 0;
    //         }
    //     }
    //     return retr;
    // }

    public static String getBar(int n){
        switch (n){
            case 1: return ":::||";
            case 2: return "::|:|";
            case 3: return "::||:";
            case 4: return ":|::|";
            case 5: return ":|:|:";
            case 6: return ":||::";
            case 7: return "|:::|";
            case 8: return "|::|:";
            case 9: return "|:|::";
            case 0: return "||:::";

        }
        return "ERROR";
    }
    public static int getDigit(String bar){
        switch (bar){
            case ":::||": return 1;
            case "::|:|": return 2;
            case "::||:": return 3;
            case ":|::|": return 4;
            case ":|:|:": return 5;
            case ":||::": return 6;
            case "|:::|": return 7;
            case "|::|:": return 8;
            case "|:|::": return 9;
            case "||:::": return 0;
        }
        return 287345;
    }
    public static String convertZIP(int[] inputCode){
        int sum = 0;
        String code = "";
        for (int i: inputCode){
            code += getBar(i);
            sum += i;
        }
        
        code += getBar(10 - (sum%10));
        return "|" + code + "|";
    }
    public static int[] convertBarcode(String inp){
        int out[] = {0, 0, 0, 0, 0};
        inp = inp.substring(1, inp.length()-2);
        for (int i = 0; i < 5; i++){
            out[i] = getDigit(inp.substring(i*5, (i+1)*5));
        }
        
        return out;
    }
}
