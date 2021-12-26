import java.util.Scanner;

public class CreditCalculator {
    public static int payment, Loan,months;
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Loan principal: 1000
                Month 1:repaid 250
                Month 2:repaid 250
                Month 3:repaid 500
                The loan has been repaid
                """);
        System.out.println("Enter the loan principal");
        Loan = scanner.nextInt();
        System.out.println("""
                What do you want to calculate?
                type "m" - for number of monthly payments,
                type "p" - for the monthly payment:""");
        String input = scanner.next();
        if (input.equals("m")) {
            System.out.println("Enter the monthly payment:");
            int pay_month = scanner.nextInt();
            if (Loan % pay_month ==0){
                months = Loan / pay_month;
            } else {
                months = Loan / pay_month +1;
            }
            System.out.println("It will take " + months + " month to repay the loan.");
        }
        if (input.equals("p")) {
            System.out.println("Enter number of month:");
            months = scanner.nextInt();
            if (Loan % months ==0){
                payment = Loan / months;
                System.out.println("Your monthly payment = " + payment);
            }
            else {
                payment = Loan / months + 1;
                int lastPayment = Loan -(months-1)*payment;
                System.out.println("Your monthly payment = " + payment + " and the last payment = " + lastPayment);
            }
        }
    }
}
