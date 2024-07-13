import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        WordScramble wordScramble = new WordScramble();

//        char[][] ar = {{'a','b','c'},
//                        {'d','e','f'}};
//
//        for(int i = 0; i <ar.length; i++) {
//            for(int j = 0; j< ar[i].length; j++) {
//                System.out.println(ar[i][j]);
//            }
//        }

        int[] a = {3, 1, 6, 8};
        Arrays.sort(a);
        for(int x : a) {
            System.out.print(x);
        }
    }
}
