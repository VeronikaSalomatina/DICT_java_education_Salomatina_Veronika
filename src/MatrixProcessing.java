import java.util.Scanner;


public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line1 = scanner.nextInt();
        int colume1 = scanner.nextInt();
        int[][] matrix1 = new int[line1][colume1];
        for (int i = 0; i < line1; i++) {
            for (int j = 0; j < colume1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }
        int line2 = scanner.nextInt();
        int colume2 = scanner.nextInt();
        int[][] matrix2 = new int[line2][colume2];
        for (int i = 0; i < line2; i++) {
            for (int i1 = 0; i1 < colume2; i1++) {
                matrix2[i][i1] = scanner.nextInt();
            }
        }
        if (matrix1.length == matrix2.length) {
            for (int i = 0; i < line1; i++) {
                for (int ii = 0; ii < colume1; ii++) {
                    System.out.print(matrix1[i][ii] + matrix2[i][ii] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }
}
