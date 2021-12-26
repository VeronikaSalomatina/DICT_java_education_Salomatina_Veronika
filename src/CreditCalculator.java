import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        float Loan, Principal, month, month_payment,i;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
        What do you want to calculate?\ntype "n" - for number of monthly payments,\ntype "a" - for annuity monthly payment amount,\ntype "p" - for the loan principal:""");
        String user = scanner.next();
        if (user.equals("n")) {
            System.out.println("Enter a loan principal:");
            Principal = scanner.nextInt();
            System.out.println("Enter the monthly payment:");
            month_payment = scanner.nextInt();
            System.out.println("Enter a loan interest:");
            Loan = scanner.nextFloat();
            month = (float) (Math.log(month_payment /(month_payment -((Loan /(12*100))* Principal)))/Math.log(1+(Loan /(12*100))));
            int period_count = Math.round(month);
            int year_count = (period_count / 12);
            int month_count = (period_count % 12);

            if (year_count>0 & month_count >0){
                System.out.println("It will take " + year_count + " years and " + month_count + " month to repay this loan");
            } else if(year_count == 0){
                System.out.println("It will take " + month_count + " month to repay this loan");
            } else {
                System.out.println("It will take " + year_count + " years to repay this loan");
            }
        }
        else if (user.equals("a")) {
            System.out.println("Enter a loan principal:");
            Principal = scanner.nextFloat();
            System.out.println("Enter the number of periods:");
            month = scanner.nextInt();
            System.out.println("Enter a loan interest:");
            Loan = scanner.nextFloat();
            month_payment = (float) (Principal *(((Loan /(12*100))*Math.pow((1+(Loan /(12*100))), month))/(Math.pow((1+(Loan /(12*100))), month)-1)));
            System.out.printf("Your monthly payment = %.0f", month_payment);
        }
        else {
            System.out.println("Enter the annuity payment:");
            month_payment = scanner.nextFloat();
            System.out.println("Enter the number of periods:");
            month = scanner.nextInt();
            System.out.println("Enter a loan interest:");
            Loan = scanner.nextFloat();
            Principal = (float) (month_payment /(((Loan /(12*100))*Math.pow((1+(Loan /(12*100))), month))/(Math.pow((1+(Loan /(12*100))), month)-1)));
            System.out.printf("Your loan principal = %.0f", Principal);
        }
    }
}
