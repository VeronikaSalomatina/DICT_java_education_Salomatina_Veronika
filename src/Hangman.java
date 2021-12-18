import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer("");
        StringBuffer user_word = new StringBuffer("");
        System.out.println("HANGMAN");
        ArrayList<String> lst = new ArrayList<>();
        lst.add("python");
        lst.add("java");
        lst.add("javascript");
        lst.add("kotlin");

        String word = lst.get(new Random().nextInt(lst.size()));
        int repeat = 0;
        buffer.append(word);
        StringBuffer help = buffer.delete(2, buffer.length());
        for (int i = 1; i <= word.length() - 2; i++) help.append("-");
        while (repeat != 8) {
            System.out.println("Guess the word" + " " + help + ":");
            int heart = 8;
            for (int i = 1; i <= word.length(); i++) user_word.append("-");
            while (heart != 0) {
                System.out.println(user_word);
                System.out.println("Input a letter:");
                String user = input.nextLine();
                if (word.equals(user)) {
                    System.out.println("You survived!");
                    break;
                    int index = word.indexOf(user);
                    if (index >= 0){
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
                        System.out.println("You lost!");
                        repeat++;
                        System.out.println("Than letter doesn't appear in the word");
                    }
                    heart--;
                }
                System.out.println("Thanks for playing!\nWe'll see how well you did in the next stage");
            }
        }