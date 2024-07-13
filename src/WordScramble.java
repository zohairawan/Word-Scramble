/*
This is a word guessing game
The user is presented with a scrambled word
The user has to guess what the unscrambled word is
Example:
    User is presented with 'ictneba'
    User has to guess that the unscrambled word is 'cabinet'

TODO: Figure out how to use more than one word (figure out the problem of spaces)
TODO: Instead of hardcoding the correct word see if you can get the word as input from a file
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordScramble {

    private String correctWord = "moon";
    //String[] scrambledWords = solution.trim().split("\s+");
    private String scrambledWord = "";
    WordScramble() {
        prompt();
        scrambleWord();
        userGuess();
    }

    void prompt() {
        System.out.println("I will present you with a scrambled word");
        System.out.println("You have to guess what the unscrambled word is");
        System.out.println("When typing your answer don't worry about upper or lower case\n");
    }

    //takes the original word and scrambles it
    void scrambleWord() {
        char[] preScramble = correctWord.toCharArray();

        ArrayList<Character> scrambled = new ArrayList<>();
        for (char letter : preScramble) {
            scrambled.add(letter);
        }

        Random random = new Random();
        while(scrambled.size() > 0) {
            int randomIndex = random.nextInt(scrambled.size());
            scrambledWord += scrambled.get(randomIndex);
            scrambled.remove(randomIndex);
        }
    }



    void userGuess() {
        Scanner kbd = new Scanner(System.in);
        String userGuess = "";
        boolean incorrect = true;
        while(!userGuess.equals(correctWord)) {
            System.out.println("Scrambled word is: " + scrambledWord);
            System.out.print("Your guess: ");
            userGuess = kbd.nextLine();
            System.out.println();
        }
        System.out.println("Congratulations, you unscrambled the word!");
    }
}

// hello car <- user input
// [hello][car] <- split string (remove white space) and store in String array
//start loop
// [h][e][l][l][o] <- char array (1 iteration captures all letters from first word)
// [e][h][l][o][l] <- ArrayList of type char
//second iteration starts (remember to add space)
//[c][a][r] <- char array
//[r][c][a] <- ArrayList of type char
//Exit condition for loop is length of split string array
//trim it at the end
//ehlol rca <- String