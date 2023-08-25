import java.util.Arrays;

// Sort Array,
// get MaxDiff = (MaxElement - MinElement) in List 
// if(arr[i] >= k){
//  Get Min Value after Deducting k Or Adding k
//  Get Max Value after Deducting k Or Adding k
// Compare Updated(Max-Min) with MaxDiff and Keep whichever is smaller
// }
public class minimizeHeightsI {
    public static void main(String[] args) {
        // int[] arr = new int[] { 1, 5, 8, 10 };
        // int[] arr = new int[] { 3, 9, 12, 16, 20 };

        int[] arr = new int[] { 8, 1, 5, 4, 7, 5, 7, 9, 4, 6 }; // 8
        System.out.println(getMinDiff(arr, arr.length, 5));
    }

    public static int getMinDiff(int[] arr, int n, int k) {
        if (arr == null || arr.length <= 1)
            return 0;

        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[n - 1];
        int res = max - min;
        for (int i = 1; i < n; i++) {
            max = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            min = Math.min(arr[0] + k, arr[i] - k);
            res = Math.min(res, max - min);
        }

        return res;
    }
}
