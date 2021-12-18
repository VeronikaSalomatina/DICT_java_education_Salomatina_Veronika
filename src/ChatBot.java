import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is Veronika.\n" +
                "I was created in 2021.\n "+"Please, remind me your name.\n");

        String name ;

        Scanner name_in=new Scanner(System.in);
        name=name_in.nextLine();
        System.out.println("What a great name you have,  "+ name+" !\n"+"Let me guess your age.\n" +
                "Enter remainders of dividing your age by 3, 5 and 7.");

        Scanner reminder3=new Scanner(System.in);
        Scanner reminder5=new Scanner(System.in);
        Scanner reminder7=new Scanner(System.in);

        int remainder3=reminder3.nextInt();
        int remainder5=reminder5.nextInt();
        int remainder7=reminder7.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is "+age+" ; that is a good time to start programming!\n Now I will prove to you that I can count to any number you want.");
        Scanner tocount=  new Scanner(System.in);
        int number=tocount.nextInt();
        if (number>=0){
            for(int i=0;i<=number;i++){
                System.out.println(i+" !\n");
            }
        }
        Scanner otvet;int otvet_in; System.out.println(" Let's test your programming knowledge. Why do we use methods? \n1. To repeat a statement multiple times. \n2. To decompose a program into several small subroutines. \n3. To determine the execution time of a program.\n 4. To interrupt the execution of a program.\n ");


        do{   otvet= new Scanner(System.in);
            otvet_in= otvet.nextInt();

            if (otvet_in != 2) {

                System.out.println("Please, try again. ");
            }
        }while (otvet_in!=2);
        System.out.println( "Great, you right! \n Goodbye, have a nice day!");

    }
}