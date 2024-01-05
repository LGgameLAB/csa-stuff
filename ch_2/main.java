class main {
    public static void main(String[] args){
        System.out.print(HollePrinter("Hello, World!"));
    }
    public static void program1(){
        String word = "Mississippi";
        word = word.replace("i", "ii");
        System.out.println(word.length());
        word = word.replace("s", "ss");
        System.out.print(word.length());
    }
    public static String HollePrinter(String word){
        // Replace E's with a filler character
        String word2 = word.replace("e", "/");
        word2 = word2.replace("o", "e");
        word2 = word2.replace("/", "o");
        return word2;
    }
}
