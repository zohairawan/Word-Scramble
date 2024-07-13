import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        WordScramble wordScramble = new WordScramble();
        String name = "Firstname Miidlename Lastname";
//        System.out.println(name);
        String[] strArray  = name.split("\s+");

        System.out.println(strArray[0]);
        System.out.println(strArray[1]);
        System.out.println(strArray[2]);
    }
}
