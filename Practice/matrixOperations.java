package Practice;

import java.util.Scanner;

public class matrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t------- Matrix-A -------");
        System.out.print("Number of Rows : ");
        int r1 = sc.nextInt();
        System.out.print("Number of Columns : ");
        int c1 = sc.nextInt();
        System.out.println("Enter Values in (" + r1 + "*" + c1 + ") Matrix :-");
        int[][] m1 = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                m1[i][j] = sc.nextInt();
            }
        }
        System.out.println();
        System.out.println("\t------- Matrix-A -------");
        System.out.print("Number of Rows : ");
        int r2 = sc.nextInt();
        System.out.print("Number of Columns : ");
        int c2 = sc.nextInt();
        System.out.println("Enter Values in (" + r2 + "*" + c2 + ") Matrix :-");
        int[][] m2 = new int[r2][c2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                m2[i][j] = sc.nextInt();
            }
        }

        int choice = -1;
        while (choice != 0) {
            System.out.println(
                    "\n\t\t $$ MENU $$ \n\t 1. Transpose Of Matrix\n\t 2. Matrix Addition \n\t 3. Matrix Multiplication \n\t 0. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    transpose(m1, r1, c1);
                    transpose(m2, r2, c2);
                    break;
                case 2:
                    add(m1, r1, c1, m2, r2, c2);
                    break;
                case 3:
                    multiply(m1, r1, c1, m2, r2, c2);
                    break;
                case 0:
                    System.out.println("Exiting! ..");
                    break;
                default:
                    System.out.println("INVALID CHOICE!!  ");
            }
        }
        sc.close();

    }

    public static void multiply(int[][] arr1, int row1, int col1, int[][] arr2, int row2, int col2) {
        if (row2 != col1) {
            System.out.println("MULTIPLICATION FAILED: Can\'t Multiply Matrices");
            return;
        }
        int[][] result = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < row2; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                } // end of k loop
            } // end of j loop
        }
        printArray(result);
    }

    public static void transpose(int[][] arr, int row, int col) {
        int[][] trapse = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                trapse[i][j] = arr[j][i];
            }
        }
        printArray(trapse);
    }

    public static void add(int[][] arr1, int row1, int col1, int[][] arr2, int row2, int col2) {
        if (row1 != row2 || col1 != col2) {
            System.out.println("ADDITION FAILED: Can\'t Add Matrices");
            return;
        }

        int[][] addition = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                addition[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println("Addition : ");
        printArray(addition);
    }

    public static void printArray(int[][] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print("[");
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
                if (j + 1 != a[0].length)
                    System.out.print(",");
            }
            System.out.print("]");
            if (i + 1 != a.length)
                System.out.print(",");
        }
        System.out.print("]");
        System.out.println();
    }
}
