public class CreditCalculator {
    public static void main(String[] args) {
        float Loan, Principal, Month, payment_of_month, Count, dif;
        int o = 0;
        String pr = System.getProperty("principal");
        String pa = System.getProperty("payment");
        String i = System.getProperty("interest");
        String t = System.getProperty("type");
        String pe = System.getProperty("periods");

        if (t == null){
            System.out.println("Incorrect parameters!!!");
            System.exit(0);
        }
        else {
            if (t.equals("annuity")) {
                if(pr != null && pa != null && i != null){
                    payment_of_month = (float) Double.parseDouble(pa);
                    Principal = (float) Double.parseDouble(pr);
                    Loan = (float) Double.parseDouble(i);
                    Count =  (Loan /(12*100));
                    Month = (float) (Math.log(payment_of_month /(payment_of_month -(Count * Principal)))/Math.log(1+ Count));
                    int period = (int) Math.round(Month),year = (period / 12),month = (period % 12);

                    if (year>0 & month >0){
                        System.out.println("It will take " + year + " years and " + month + " month to repay this loan");
                    }
                    else if(year == 0){
                        System.out.println("It will take "+ month + " month to repay this loan");
                    }
                    else {
                        System.out.println("It will take "+ year + " years to repay this loan");
                    }
                }

                else if (pe != null && pa != null && i != null) {
                    Month = (float) Double.parseDouble(pe);
                    payment_of_month = (float) Double.parseDouble(pa);
                    Loan = (float) Double.parseDouble(i);
                    Count =  (Loan /(12*100));

                    Principal = (float) (payment_of_month /((Count *Math.pow((1+ Count), Month))/(Math.pow((1+ Count), Month)-1)));
                    System.out.printf("Your loan principal = %.0f", Principal);
                }

                else if (pr != null && pe != null && i != null){
                    Principal = (float) Double.parseDouble(pr);
                    Month = (float) Double.parseDouble(pe);
                    Loan = (float) Double.parseDouble(i);
                    Count =  (Loan /(12*100));

                    payment_of_month = (float) (Principal *((Count *Math.pow((1+ Count), Month))/(Math.pow((1+ Count), Month)-1)));
                    System.out.printf("Your monthly payment = %.0f", payment_of_month);
                }else {
                    System.out.println("Incorrect parameters.");
                    System.exit(0);
                }
            }else if (t.equals("diff")) {
                if (pr == null || pe == null || i == null) {
                    System.out.println("Incorrect parameters!!!");
                    System.exit(0);
                }
                Month = (float) Double.parseDouble(pe);
                Principal = (float) Double.parseDouble(pr);
                Loan = (float) Double.parseDouble(i);
                Count = (Loan / (12 * 100));
                for (int m = 1; m <= Month; m++) {
                    dif = Principal / Month + Count * (Principal - ((Principal * (m - 1)) / (Month)));
                    dif = Math.round(dif);
                    o = (int) (o + (dif - (Principal / Month)));
                    System.out.println("Month " + m + ": payment is " + dif);
                }
                System.out.println("Overpayment = " + o);
            } else {
                System.out.println("Incorrect parameters!!!");
                System.exit(0);
            }
        }
    }
}
