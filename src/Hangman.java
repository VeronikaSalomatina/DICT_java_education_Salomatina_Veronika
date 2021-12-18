import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
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
            System.out.println(user_word);
            System.out.println("\n" + user_word);
            System.out.println("Input a letter:");
            String user = input.nextLine();
            int index = word.indexOf(user);
            if (index >= 0){
                if (index < 0 || storage.contains(user)){
                    if (storage.contains(user)) {
                        System.out.println("No improvements");
                    } else {
                        System.out.println("Than letter doesn't appear in the word");
                    }
                    storage.add(user);
                    heart--;

                } else {
                    storage.add(user);
                    if (user.equals("a")){
                        user_word.insert(index, user);
                        user_word.delete(index + 1, index + 2);
                        user_word.insert(index + 2, user);
                        user_word.delete(index + 3, index + 4);
                    } else {
                        user_word.insert(index, user);
                        user_word.delete(index + 1, index + 2);
                    }
                } else {
                    System.out.println("Than letter doesn't appear in the word");
                    if (word.contains(user_word)) {
                        System.out.println(user_word + "\nYou guessed the word!\nYou survived!");
                        break;
                    }
                }
                heart--;
            }
            System.out.println("Thanks for playing!\nWe'll see how well you did in the next stage");
            if (0 >= heart){
                System.out.println("You lost!");
            }
        }
    }