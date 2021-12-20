import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        List<String> words = Arrays.asList("python", "java", "javascript", "kotlin");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> past_word = new ArrayList<>();
        String word = words.get(new Random().nextInt(words.size()));
        int attempts = 8;

        while (true) {
            StringBuffer guess = new StringBuffer();
            guess.append("-".repeat(word.length()));

            System.out.println("Type \"play\" to play tha game, \"exit\" to exit ");
            String main_choice = scanner.nextLine();
            if (main_choice.equals("exit")) {
                break;
            } else if (main_choice.equals("play")){
                Play(attempts, guess, word, past_word);
            }
        }
    }
    public static void Transformation (String user, StringBuffer guess, int index) {
        if (user.equals("a")) {
            guess.insert(index, user);
            guess.delete(index + 1, index + 2);
            guess.insert(index + 2, user);
            guess.delete(index + 3, index + 4);
        } else {
            guess.insert(index, user);
            guess.delete(index + 1, index + 2);
        }
    }

    public static void Play (int attempts, StringBuffer guess, String word, List<String> past_word) {
        Scanner scanner = new Scanner(System.in);
        while (attempts != 0) {
            System.out.println("\n" + guess);
            System.out.println("Input a letter:");
            String user = scanner.nextLine();
            int index = word.indexOf(user);
            Pattern pattern = Pattern.compile("[a-z]");
            Matcher matcher = pattern.matcher(user);
            if (index < 0 || past_word.contains(user) || (index == 0 && user.length() == 0)) {
                if (user.length() != 1) {
                    System.out.println("You should input a single letter");
                } else if (!matcher.matches()) {
                    System.out.println("Please enter a lowercase English letter");
                } else if (past_word.contains(user)) {
                    System.out.println("You already guessed this letter");
                } else {
                    System.out.println("That letter doesn't appear in the word");
                    attempts--;
                }
                past_word.add(user);

            } else {
                past_word.add(user);
                Transformation (user, guess, index);
                if (word.contains(guess)) {
                    System.out.println(guess + "\nYou guessed the word " + guess + "!\nYou survived!\n");
                    break;
                }
            }

        }
        if (0 >= attempts) {
            System.out.println("You lost!\n");
        }
    }
}