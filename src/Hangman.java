import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuffer user_word = new StringBuffer("");
        System.out.println("HANGMAN");
        ArrayList<String> lst = new ArrayList<>();
        ArrayList<String> storage = new ArrayList<>();
        lst.add("python");
        lst.add("java");
        lst.add("javascript");
        lst.add("kotlin");
        String word = lst.get(new Random().nextInt(lst.size()));
        int heart = 8;
        for (int i = 1; i <= word.length(); i++) user_word.append("-");
        while (heart != 0) {
            System.out.println("\n" + user_word);
            System.out.println("Input a letter:");
            String user = input.nextLine();
            int index = word.indexOf(user);
//            System.out.println(check);
            Pattern pattern = Pattern.compile("[a-z]");
            Matcher matcher = pattern.matcher(user);

            if (index < 0 || storage.contains(user)) {
                if (storage.contains(user)) {
                    System.out.println("No improvements");
                } else {
                    System.out.println("Than letter doesn't appear in the word");
                    if (index < 0 || storage.contains(user) || (index == 0 && user.length() == 0)) {
                        if (user.length() != 1) {                  // проверка на ввод одной буквы
                            System.out.println("You should input a single letter");
                        } else if (!matcher.matches()) {           // проверка на ввод только маленьких букв
                            System.out.println("Please enter a lowercase English letter");
                        } else if (storage.contains(user)) {       // проверка на повторение
                            System.out.println("You already guessed this letter");
                        } else {
                            System.out.println("That letter doesn't appear in the word");
                            heart--;
                        }
                        storage.add(user);
                        heart--;
//

                    } else {
//                boolean check_storage = storage.contains(user);
                        storage.add(user);
                        if (user.equals("a")) {
                            user_word.insert(index, user);
                            user_word.delete(index + 1, index + 2);
                            user_word.insert(index + 2, user);
                            user_word.delete(index + 3, index + 4);
                        } else {
                            user_word.insert(index, user);
                            user_word.delete(index + 1, index + 2);
                        }
                        if (word.contains(user_word)) {
                            System.out.println(user_word + "\nYou guessed the word!\nYou survived!");
                            System.out.println(user_word + "\nYou guessed the word " + user_word + "!\nYou survived!");
                            break;
                        }
                    }
                }
                if (0 >= heart) {
                    System.out.println("You lost!");
                }
            }
        }
    }
}
