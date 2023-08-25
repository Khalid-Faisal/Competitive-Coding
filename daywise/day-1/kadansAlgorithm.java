//https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

// Two Variables - Local_Sum and Global_Sum
// for loop -> continously add values to Local_Sum
// If Local_Sum < Value itself (Previous Sum is far lower)
// Then assign Local_Sum = Value
// Check of Local_Sum > Global_Sum Then update Global_Sum

public class kadansAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[] { 9, 1, 4, -22, 3, 0, 5, 9, -2, 2, 7 };
        // int[] arr = new int[] { 1, 2, 3, -2, 5 };
        // int[] arr = new int[] { -1, -2, -3, -4, -5 };
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    public static long maxSubarraySum(int arr[], int n) {
        long max_so_far = Integer.MIN_VALUE, max_end_here = 0;
        // Your code here
        for (int i = 0; i < n; i++) {
            max_end_here += arr[i];
            if (max_end_here < arr[i])
                max_end_here = arr[i];
            if (max_so_far < max_end_here)
                max_so_far = max_end_here;
        }
        return max_so_far;

    }
}
