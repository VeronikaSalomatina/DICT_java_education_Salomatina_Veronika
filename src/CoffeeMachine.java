package CoffeeMachine;
import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = input.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = input.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee_beans = input.nextInt();
        var count = new int[] {water / 200, milk / 50, coffee_beans / 15};
        var min = Arrays.stream(count).min();
//        System.out.println(min.getAsInt());
        System.out.println("Write how many cups of coffee you will need:");
        int cup = input.nextInt();
        if (min.getAsInt() == cup){
            System.out.println("Yes, I can make that amount of coffee");
        } else if (min.getAsInt() > cup) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (min.getAsInt() - cup) + " more than that)");
        }else {
            System.out.println("No, I can make only " + min.getAsInt() + " cups of coffee");

            // w = water, m = milk, cb = coffee beans, c = cup, $ = money
            Integer[] w_m_cb_c_$ = new Integer[]{400, 540, 120, 9, 550};

            System.out.println(Output.output(w_m_cb_c_$));
            System.out.println("\nWrite action (buy, fill, take):");
            String action = input.nextLine();
            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    int drink = input.nextInt();
                    switch (drink) {
                        case 1 -> {  // espresso
                            w_m_cb_c_$[0] -= 250;
                            w_m_cb_c_$[2] -= 16;
                            w_m_cb_c_$[4] += 4;
                        }
                        case 2 -> {  // latte
                            w_m_cb_c_$[0] -= 350;
                            w_m_cb_c_$[1] -= 75;
                            w_m_cb_c_$[2] -= 20;
                            w_m_cb_c_$[4] += 7;
                        }
                        case 3 -> {  // cappuccino
                            w_m_cb_c_$[0] -= 200;
                            w_m_cb_c_$[1] -= 100;
                            w_m_cb_c_$[2] -= 12;
                            w_m_cb_c_$[4] += 6;
                        }
                    }
                    w_m_cb_c_$[3]--;
                    System.out.println(Output.output(w_m_cb_c_$));
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add:");
                    int water_to_add = input.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milk_to_add = input.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int cb_to_add = input.nextInt();
                    System.out.println("Write how many disposable coffee cups you want to add:");
                    int cups_to_add = input.nextInt();
                    w_m_cb_c_$[0] += water_to_add;
                    w_m_cb_c_$[1] += milk_to_add;
                    w_m_cb_c_$[2] += cb_to_add;
                    w_m_cb_c_$[3] += cups_to_add;
                    System.out.println(Output.output(w_m_cb_c_$));
                }
                case "take" -> {
                    System.out.println("I give you " + w_m_cb_c_$[4]);
                    w_m_cb_c_$[4] -= w_m_cb_c_$[4];
                    System.out.println(Output.output(w_m_cb_c_$));
                }
            }
        }
    }

    class Output {
        // w = water, m = milk, cb = coffee beans, c = cup, $ = money
        public static String output(Integer[] w_m_cb_c_$){
            return ("\nThe coffee machine has:\n" +
                    w_m_cb_c_$[0] + " of water\n" +
                    w_m_cb_c_$[1] + " of milk\n" +
                    w_m_cb_c_$[2] + " of coffee beans\n" +
                    w_m_cb_c_$[3] + " of disposable cups\n" +
                    w_m_cb_c_$[4] + " of money");
        }
    }
