import java.util.Scanner;


public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int colume = scanner.nextInt();
        int[][] matrix = new int[line][colume];
        for (int i = 0; i < line; i++) {
            for (int ii = 0; ii < colume; ii++) {
                matrix[i][ii] = scanner.nextInt();
            }
        }
        int constanta = scanner.nextInt();
        for (int i = 0; i < line; i++) {
            for (int ii = 0; ii < colume; ii++) {
                System.out.print(matrix[i][ii] * constanta + " ");
            }
            System.out.println();
        }
    }
}
