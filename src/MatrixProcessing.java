import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c;
        int a;
        int[] size = new int[2];
        int[] size2 = new int[2];
        int[][] matrix = new int[0][];
        int[][] matrix2 = new int[0][];
        int[][] matrix3 = new int[0][];
        for (; ; ) {
            System.out.println("1. Add matrices\n" +
                    "2. Multiply matrix by a constant\n" +
                    "3. Multiply matrices\n" +
                    "4. Transpose matrix\n" +
                    "5. Exit");
            System.out.print("You choice:");
            a = in.nextInt();
            if (a == 5){
                System.exit(0);
            }
            System.out.print("Enter size matrix: ");
            size[0] = in.nextInt();
            size[1] = in.nextInt();
            matrix = new int[size[0]][size[1]];
            System.out.println("Enter matrix: ");
            for (int q = 0; q < size[0]; q++) {
                for (int w = 0; w < size[1]; w++) {
                    matrix[q][w] = in.nextInt();
                }
                matrix2 = new int[size[0]][size[1]];
                if (a == 1) {
                    System.out.println("Enter second matrix: ");
                    matrix3 = new int[size[0]][size[1]];
                    for (q = 0; q < size[0]; q++) {
                        for (int w = 0; w < size[1]; w++) {
                            matrix2[q][w] = in.nextInt();
                        }
                    }
                    for (q = 0; q < size[0]; q++) {
                        for (int w = 0; w < size[1]; w++) {
                            matrix3[q][w] = matrix[q][w] + matrix2[q][w];
                        }
                    }
                    for (q = 0; q < size[0]; q++) {
                        for (int w = 0; w < size[1]; w++) {
                            System.out.print("|" + matrix3[q][w] + "|");
                        }
                        System.out.println();
                    }
                }else if (a==2){
                    System.out.println("Enter constant: ");
                    c = in.nextInt();
                    for (q = 0; q < size[0]; q++) {
                        for (int w = 0; w < size[1]; w++) {
                            matrix2[q][w] = matrix[q][w]*c;
                        }
                    }
                    for (q = 0; q < size[0]; q++) {
                        for (int w = 0; w < size[1]; w++) {
                            System.out.print("|" + matrix2[q][w] + "|");
                        }
                        System.out.println();
                    }
                }else if (a==3){
                    System.out.print("Enter size second matrix: ");
                    size2[0] = in.nextInt();
                    size2[1] = in.nextInt();
                    matrix2 = new int [size[0]][size[1]];
                    System.out.println("Enter second matrix: ");
                    for (int i = 0; i < size2[0]; i++) {
                        for (int i1 = 0; i1 < size2[1]; i1++) {
                            matrix2[i][i1] = in.nextInt();
                        }
                    }
                    matrix3 = new int[size[0]][size2[1]];
                    for (q = 0; q < size[0]; q++) {
                        for (int w = 0; w < size2[1]; w++) {
                            matrix3[q][w] = 0;
                        }
                    }
                    if (size[1] == size2[0]) {
                        for (q = 0; q < size[0]; q++) {
                            for (int w = 0; w < size2[1]; w++) {
                                for (int e = 0; e < size[1]; e++) {
                                    matrix3[q][w] = matrix3[q][w] + matrix[q][e]* matrix2[e][w];
                                }
                            }
                        }
                        for (q = 0; q < size[0]; q++) {
                            for (int w = 0; w < size[1]; w++) {
                                System.out.print("|" + matrix3[q][w] + "|");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("ERROR");
                    }
                } else if (a == 4) {
                    System.out.println("1. Main diagonal\n2. Side diagonal\n3. Vertical line\n4. Horizontal line");
                    a = in.nextInt();
                    matrix2 = new int[size[1]][size[0]];
                    matrix3 = new int[size[0]][size[1]];
                    if (a == 1) {
                        for (q = 0; q < size[1]; ++q) {
                            for (int w = 0; w < size[0]; ++w) {
                                matrix2[q][w] = matrix[w][q];
                            }
                        }
                        for (q = 0; q < size[1]; ++q) {
                            for (int w = 0; w < size[0]; ++w) {
                                System.out.print("|" + matrix2[q][w] + "|");
                            }
                            System.out.println();
                        }
                    } else if (a == 2) {
                        for (q = 0; q < size[0]; ++q) {
                            for (int w = 0; w < size[1]; ++w) {
                                matrix2[w][q] = matrix[size[0] - (q + 1)][size[1] - (w + 1)];
                            }
                        }
                        for (q = 0; q < size[1]; ++q) {
                            for (int w = 0; w < size[0]; ++w) {
                                System.out.print("|" + matrix2[q][w] + "|");
                            }
                        }
                        System.out.println();
                    }
                } else if (a == 3) {
                    for (q = 0; q < size[0]; ++q) {
                        for (int w = 0; w < size[1]; ++w) {
                            matrix3[q][w] = matrix[q][size[1] - (w + 1)];
                        }
                        System.out.println();
                    }
                    for (q = 0; q < size[0]; ++q) {
                        for (int w = 0; w < size[1]; ++w) {
                            System.out.print("|" + matrix3[q][w] + "|");
                        }
                        System.out.println();
                    }
                } else if (a == 4) {
                    for (q = 0; q < size[0]; ++q) {
                        for (int w = 0; w < size[1]; ++w) {
                            matrix3[q][w] = matrix[size[0] - (q + 1)][w];
                        }
                        System.out.println();
                    }
                    for (q = 0; q < size[0]; ++q) {
                        for (int w = 0; w < size[1]; ++w) {
                            System.out.print("|" + matrix3[q][w] + "|");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }
}
