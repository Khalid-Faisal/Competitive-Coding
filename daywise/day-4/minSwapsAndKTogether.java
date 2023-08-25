// Initialize Two variable Favourable element and Non favourable element in Current window.
// Window Size = k (As it is asked to check min swaps to gather k elements)
// Count Fav and non Fav element in Window-1 (0-k)
// Iterate Over remaining window by sliding (0 to k, 1 to k+1 etc)
// return the minSwaps ie min non-fav elements in particular window

public class minSwapsAndKTogether {
    public static void main(String[] args) {
        System.out.println(minSwap(new int[] { 2, 1, 5, 6, 3 }, 5, 3)); // 1
        System.out.println(minSwap(new int[] { 2, 7, 9, 5, 8, 7, 4 }, 7, 6)); // 2
        System.out.println(minSwap(new int[] { 20, 12, 17 }, 3, 6)); // 0
        System.out.println(minSwap(new int[] { 10, 12, 20, 20, 5, 19, 19, 12, 1, 20, 1 }, 11, 1)); // 1
        System.out.println(
                minSwap(new int[] { 4, 11, 6, 5, 11, 20, 19, 14, 14, 2, 9, 20, 11, 11, 15, 1, 7, 12, 19, 9 }, 20, 14)); // 4
    }

    public static int minSwap(int arr[], int n, int k) {
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;

        // Find unwanted elements in current
        // window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++bad;

        // Initialize answer with 'bad' value of
        // current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {

            // Decrement count of previous window
            if (arr[i] > k)
                --bad;

            // Increment count of current window
            if (arr[j] > k)
                ++bad;

            // Update ans if count of 'bad'
            // is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;

    }
}
