// package day-5;
//Just cout the conseq 1's in row as well as col
public class maxRectangle {
    public static void main(String[] args) {
        System.out
                .println(maxArea(new int[][] { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } }, 4, 4));
        // System.out.println(maxArea(new
        // int[][]{{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}}, 4, 4));
    }

    public static int maxArea(int M[][], int n, int m) {
        // add code here.
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 1;
                if (M[i][j] == 1) {
                    while (M[i][j] != 0) {
                        count++;
                        j++;
                        if (j >= m)
                            break;
                    }
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 1;
                if (M[i][j] == 1) {
                    while (M[i][j] != 0) {
                        count++;
                        i++;
                        if (i >= n)
                            break;
                    }
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }
}
