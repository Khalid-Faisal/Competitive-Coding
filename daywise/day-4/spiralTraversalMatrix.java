import java.util.ArrayList;

public class spiralTraversalMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        int[][] matrix2 = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println(spirallyTraverse(matrix1, matrix1.length, matrix1[0].length));
        System.out.println(spirallyTraverse(matrix2, matrix2.length, matrix2[0].length));
    }

    public static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> result = new ArrayList<>();
        int rowBegin = 0, columnBegin = 0;
        int rowEnd = r - 1, columnEnd = c - 1;
        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            // traverse row left-right
            for (int i = columnBegin; i <= columnEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // traverse column top-down
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            // traverse row right-left
            if (rowBegin <= rowEnd) {
                for (int i = columnEnd; i >= columnBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // traverse column down-top
            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][columnEnd]);
                }
            }
            columnBegin++;
        }
        return result;
    }
}
