import java.util.Arrays;

public class medianOfRowWise {
    public static void main(String[] args) {
        System.out.println(median(new int[][] { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } }, 3, 3));
        // System.out.println(median(new int[][] { { 1 }, { 2 }, { 3 } }, 3, 1));
    }

    public static int median(int matrix[][], int R, int C) {
        int N = R * C;
        int medianIndex = N / 2;
        int start = 1;
        int end = 2000;

        while (start <= end) {
            int assumedMedian = start + (end - start) / 2;
            int lesserElements = findSmallerElements(matrix, assumedMedian);
            if (lesserElements <= medianIndex) {
                start = assumedMedian + 1;
            } else {
                end = assumedMedian - 1;
            }
        }
        return start;
    }

    public static int findSmallerElements(int[][] matrix, int assumedMedian) {
        int noOfSmallerElements = 0;
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] <= assumedMedian) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            noOfSmallerElements += start;
        }
        return noOfSmallerElements;
    }

    // Inefficient Solution
    // Time Complexity = O(R*C)
    // Space Complexity = O(R*C)
    public static int medianBruteForce(int matrix[][], int R, int C) {
        int[] arr = new int[R * C];
        for (int i = 0, k = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[k++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }
}
