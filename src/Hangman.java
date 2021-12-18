import java.util.Objects;
import java.util.Scanner;


public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");

        String user = scanner.nextLine();
        if (Objects.equals(user, "java")){
            System.out.println("You survived!");
        } else{
            System.out.println("You lost!");
        }
    }
}