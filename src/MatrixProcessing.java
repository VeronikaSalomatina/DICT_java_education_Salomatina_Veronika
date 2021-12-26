import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("""
            1. Add matrices
            2. Multiply matrix by constant
            3. Multiply matrices
            4. Exit
            """);
            System.out.println("Choose your action:");
            String user = scan.next();
            if (user.equals("1")){
                sum();
            }
            else if (user.equals("2")){
                constants();
            }
            else if (user.equals("3")){
                mult();
            }
            else {
                break;
            }
        }
    }
    public static void sum(){
        Scanner scanner = new Scanner(System.in);
        int row_first = scanner.nextInt();
        int column_first = scanner.nextInt();
        int[][] first_matrix = new int[row_first][column_first];
        for (int i = 0; i < row_first; i++) {
            for (int j = 0; j < column_first; j++) {
                first_matrix[i][j] = scanner.nextInt();
            }
        }
        int row_second = scanner.nextInt();
        int column_second = scanner.nextInt();
        int[][] second_matrix = new int[row_second][column_second];
        for (int i = 0; i < row_second; i++) {
            for (int j = 0; j < column_second; j++) {
                second_matrix[i][j] = scanner.nextInt();
            }
        }
        if (first_matrix.length == second_matrix.length) {
            System.out.println("Sum: ");
            for (int i = 0; i < row_first; i++) {
                for (int j = 0; j < column_second; j++) {
                    System.out.print(first_matrix[i][j] + second_matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        else {System.out.println("ERROR");
        }
    }
    public static void constants(){
        Scanner scanner_2 = new Scanner(System.in);
        int line_A = scanner_2.nextInt();
        int column_A = scanner_2.nextInt();
        int[][] matrixA = new int[line_A][column_A];
        for (int i = 0; i < line_A; i++) {
            for (int j = 0; j < column_A; j++) {
                matrixA[i][j] = scanner_2.nextInt();
            }
        }
        int constant = scanner_2.nextInt();
        System.out.println("Multiplication Constanta: ");
        for (int i = 0; i < line_A; i++) {
            for (int j = 0; j < column_A; j++) {
                System.out.print(matrixA[i][j] * constant+ " ");
            }
            System.out.println();
        }
    }
    public static void mult(){
        Scanner scanner_3 = new Scanner(System.in);
        System.out.print("Enter size of first matrix: ");
        int[] first_matrix = new int[2];
        for (int i = 0; i < 2; i++) {
            first_matrix[i] = scanner_3.nextInt();
        }
        System.out.println("Enter first  matrix: ");
        double[][] first_matrix_value = new double[first_matrix[0]][first_matrix[1]];
        for (int i = 0; i < first_matrix[0]; i++) {
            for (int j = 0; j < first_matrix[1]; j++) {
                first_matrix_value[i][j] = scanner_3.nextDouble();
            }
        }
        System.out.print("Enter second matrix: ");
        int[] second_matrix = new int[2];
        for (int i = 0; i < 2; i++) {
            second_matrix[i] = scanner_3.nextInt();
        }
        System.out.println("Enter second matrix: ");
        double[][] second_matrix_value = new double[second_matrix[0]][second_matrix[1]];
        for (int i = 0; i < second_matrix[0]; i++) {
            for (int j = 0; j < second_matrix[1]; j++) {
                second_matrix_value [i][j] = scanner_3.nextDouble();
            }
        }
        double[][] resultMultiplication = new double[first_matrix[0]][second_matrix[1]];
        for (int line_a = 0; line_a < first_matrix[0]; line_a++) {
            for (int column_b = 0; column_b < second_matrix[1]; column_b++) {
                resultMultiplication [line_a][column_b] = 0;
            }
        }
        if (second_matrix[0] == first_matrix[1]) {
            System.out.println("Multiplication");
            for (int line = 0; line < first_matrix[0]; line++) {
                for (int column = 0; column < second_matrix[1]; column++) {
                    for (int value = 0; value < first_matrix[1]; value++) {
                        resultMultiplication[line][column] = resultMultiplication[line][column] + first_matrix_value[line][value] * second_matrix_value[value][column];
                    }
                    System.out.print(resultMultiplication[line][column] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }
}
