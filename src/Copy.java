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

import java.util.*;

public class Copy {

    //String[] scrambledWords = solution.trim().split("\s+");
    String[] wordList = {"now", "one", "two"};
    Random rand = new Random();
    int index = rand.nextInt(wordList.length);

    private String correctWord = wordList[index];
    private String scrambledWord = "";
    Copy() {
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
        char[] preScramble = correctWord.toCharArray();     //moon -> [m][o][o][n]

        ArrayList<Character> scrambled = new ArrayList<>(); // {[m][o][o][n]}
        for (char letter : preScramble) {
            scrambled.add(letter);
        }

        Random random = new Random();
        while(scrambled.size() > 0) {
            int randomIndex = random.nextInt(scrambled.size());  // {}
            scrambledWord += scrambled.get(randomIndex);                //  omon
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

//package MyScramble;
//
//        import java.util.*;;
//
//public class WordScramble {
//
//    Map<String, HashMap<String, ArrayList<String>>> wordMap = new HashMap<>() {{
//        put("easy", new HashMap<String, ArrayList<String>>() {{
//            put("words", new ArrayList<String>() {{
//                add("ridge");
//                add("youth");
//                add("horse");
//                add("stand");
//                add("flush");
//            }});
//            put("hints", new ArrayList<String>() {{
//                add("mountain");
//                add("kid");
//                add("cowboy");
//                add("JoJo");
//                add("poop");
//            }});
//        }});
//        put("medium", new HashMap<String, ArrayList<String>>() {{
//            put("words", new ArrayList<String>() {{
//                add("occupy");
//                add("artist");
//                add("lesson");
//                add("battle");
//                add("copper");
//            }});
//            put("hints", new ArrayList<String>() {{
//                add("take");
//                add("Van Gogh");
//                add("school");
//                add("war");
//                add("wires");
//            }});
//        }});
//        put("hard", new HashMap<String, ArrayList<String>>() {{
//            put("words", new ArrayList<String>() {{
//                add("verdict");
//                add("sulphur");
//                add("retired");
//                add("plastic");
//                add("concept");
//            }});
//            put("hints", new ArrayList<String>() {{
//                add("court");
//                add("boom");
//                add("old");
//                add("straw");
//                add("idea");
//            }});
//        }});
//    }};
//
//
//    String difficulty = "easy", currentWord = "", scrambledWord = "", hint = "";
//    boolean gameFinished = false;
//
//    Scanner sc = new Scanner(System.in);
//    Random rand = new Random();
//
//
//    // ------------------------------------------------------------------------------
//    public String scrambleWord(String word) {
//        StringBuilder builder = new StringBuilder("");
//
//        List<String> split = new ArrayList<String>(Arrays.asList(word.split("")));
//        Collections.shuffle(split);
//        split.forEach(builder::append);
//
//        return builder.toString();
//    }
//
//    // ------------------------------------------------------------------------------
//    public void getRandomWord() {
//        int index = rand.nextInt(wordMap.get(difficulty).get("words").size());
//
//        currentWord = wordMap.get(difficulty).get("words").remove(index);
//        scrambledWord = scrambleWord(currentWord);
//        hint = wordMap.get(difficulty).get("hints").remove(index);
//    }
//
//    // ------------------------------------------------------------------------------
//    public boolean continueOrNot() {
//        System.out.print("\nWould you like to continue? (y/n): ");
//        String input = sc.next();
//        System.out.println("\n");
//
//        return (input.equals("y")) || (input.equals("yes"));
//    }
//
//    // ------------------------------------------------------------------------------
//    public void userGuess() {
//        boolean continueGuessing = true;
//        while (continueGuessing) {
//            System.out.printf(
//                    """
//                      Unscramble -> : %s
//                         Hint    -> : %s
//                    """, scrambledWord, hint
//            );
//            System.out.print("\nEnter your answer: ");
//            String input = sc.next();
//
//            if (input.equals(currentWord)) {
//                System.out.println("\nYou got it correct!");
//                continueGuessing = false;
//                continue;
//            }
//
//            System.out.println("\nIncorrect, please try again.");
//        }
//
//    }
//
//    // ------------------------------------------------------------------------------
//    public void setDifficulty(String diff) {
//        System.out.printf(
//                """
//
//                =============================
//                  Changing difficulty to %s
//                =============================
//
//                """, diff
//        );
//        this.difficulty = diff;
//    }
//
//    // ------------------------------------------------------------------------------
//    public void endGame() {
//        System.out.println("Congradulations, you have finished the game!");
//        gameFinished = true;
//    }
//
//    // ------------------------------------------------------------------------------
//    public WordScramble() {
//        System.out.printf(
//                """
//                  _______________________________________________
//                  ========= Welcome to Word Scramble! ===========
//                  ===============================================
//
//                  Current Difficulty: %s
//
//
//                """, difficulty
//        );
//
//        // Main Game Loop
//        do {
//            getRandomWord();
//            userGuess();
//
//            switch (difficulty) {
//                case "easy" -> { if (wordMap.get(difficulty).get("words").isEmpty()) { setDifficulty("medium"); }}
//                case "medium" -> { if (wordMap.get(difficulty).get("words").isEmpty()) { setDifficulty("hard"); }}
//                case "hard" -> { if (wordMap.get(difficulty).get("words").isEmpty()) { endGame(); }}
//            }
//
//        } while ((!gameFinished) ? continueOrNot() : false);
//
//        System.out.println("\nThank you for playing!\n\n");
//    }
//
//
//    // ------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        new WordScramble();
//    }
//}
