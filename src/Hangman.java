import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer("");
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
            String user = input.nextLine();
            if (word.equals(user)) {
                System.out.println("You survived!");
                break;
            } else {
                System.out.println("You lost!");
                repeat++;
            }
        }
    }
}