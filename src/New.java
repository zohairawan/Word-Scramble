import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class New {

    New() {
        instructions();
        addWords();
        userGuess();
    }

    String[] wordListEasy = {"one", "two", "three", "four"};
    String[] wordListMedium = {"batter", "construction"};
    int difficulty = 1;
    ArrayList<String> dynamicWordList = new ArrayList<>();
    String answer;
    Random randomNumGenerator = new Random();;
    String scrambledWord = "";
    Scanner kbd = new Scanner(System.in);

    void instructions() {
        System.out.println("I will present you with a scrambled word");
        System.out.println("You have to guess what the unscrambled word is");
        System.out.println("When typing your answer don't worry about upper or lower case\n");
    }

    void addWords() {
        switch(difficulty) {
            case 1 -> dynamicWordList.addAll(Arrays.asList(wordListEasy));
            case 2 -> dynamicWordList.addAll(Arrays.asList(wordListMedium));
            default -> {
                System.exit(0);
            }
        }
    }

    void getWordFromList() {
        int index = randomNumGenerator.nextInt(dynamicWordList.size());
//        answer = dynamicWordList.get(index);
        answer = dynamicWordList.remove(index);
    }

    void scrambleWord() {
        String[] separatedWord = answer.split("\s+");
        for (String s : separatedWord) {
            char[] letters = s.toCharArray();
            ArrayList<Character> scrambleLetters = new ArrayList<>();

            for (char letter : letters) {
                scrambleLetters.add(letter);
            }

            while (scrambleLetters.size() > 0) {
                int index = randomNumGenerator.nextInt(scrambleLetters.size());
                scrambledWord += scrambleLetters.get(index);
                scrambleLetters.remove(index);
            }
            scrambledWord += " ";
        }
        scrambledWord = scrambledWord.trim();
    }

    void prompt() {
        System.out.println("'q' to quit");
        System.out.println("(words remaining):" + (dynamicWordList.size()+1));
        System.out.println("Scrambled word is " + scrambledWord);
        System.out.print("Your guess: ");
    }

    void userGuess() {
        String userGuess;
        int answeredCorrectly = 0;
        int numberOfAttempts = 0;

        do {
            getWordFromList();
            scrambleWord();
            prompt();
            userGuess = kbd.nextLine();
            while(!userGuess.equals(answer) && !userGuess.equals("q")) {
                System.out.println("\nYou got it wrong, try again");
                System.out.println("Scrambled word is " + scrambledWord);
                System.out.print("Your guess: ");
                userGuess = kbd.nextLine();
                numberOfAttempts++;
            }

            System.out.println("\nYou got it right!");
            scrambledWord = "";
            answeredCorrectly++;
            numberOfAttempts++;

            if (dynamicWordList.size() == 0) {
                if(difficulty + 1 > 2) {
                    System.out.println("You finished the game!");
                    break;
                }
                System.out.println("\n---------MOVING ON TO LEVEL " + (difficulty+1) + "----------\n");
                difficulty++;
                addWords();
            }
        }while(!userGuess.equals("q"));
        System.out.println("Thanks for playing");
        System.out.println("Your accuracy was: " + ((float) answeredCorrectly/numberOfAttempts) * 100 + "%");
    }

    public static void main(String[] args) {
        New obj = new New();
    }
}