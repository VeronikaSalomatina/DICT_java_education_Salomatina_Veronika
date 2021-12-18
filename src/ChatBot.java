import java.util.Scanner;
public class ChatBot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! My name is Veronika.\nI was created in 2021.\nPlease, remind me your name.");
        String your_name = input.nextLine();
        System.out.println("What a great name you have, " + your_name + "!");
        System.out.println("Let me guess your age.\n Нужно вписать остатки от деления своего возраста на 3,5 и 7");
        int remainder3 = input.nextInt();
        int remainder5 = input.nextInt();
        int remainder7 = input.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
        System.out.println("Now I will prove to you that I can count to any number want.");
        int count = input.nextInt();
        int i = 0;
        while (i <= count){
            System.out.println(i + " !");
            i++;
        }
    }
}