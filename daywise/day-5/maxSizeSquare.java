
// package day-5;
// Use DP, 
// for First Row or Column Keep as it is (i==0 || j==0)
// for remaining elements MIN(Left, Top, LeftTopDiagonal) + 1
// Return Max from Matrix
import java.util.Arrays;

public class maxSizeSquare {
    public static void main(String[] args) {
        // System.out.println(maxSquare(2, 2, new int[][] { { 1, 1 }, { 1, 1 } }));
        // System.out.println(maxSquare(2, 2, new int[][] { { 0, 0 }, { 0, 0 } }));
        System.out.println(maxSquare(4, 5,
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0 },
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 0 } }));
    }

    public static int maxSquare(int n, int m, int mat[][]) {
        // code here
        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    if (mat[i][j] == 1)
                        dp[i][j] = 1;
                } else {
                    if (mat[i][j] == 1)
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        // System.out.println(Arrays.toString(dp[i]));
        // }
        return ans;
    }
}
