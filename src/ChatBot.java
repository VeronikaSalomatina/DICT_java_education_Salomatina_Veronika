import java.util.Scanner;
public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! My name is Veronika.\nI was created in 2021.\nPlease, remind me your name.");
        String your_name = scanner.nextLine();
        System.out.println("What a great name you have, " + your_name + "!");
        System.out.println("Let me guess your age.\nНужно вписать остатки от деления своего возраста на 3,5 и 7");
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }
}

