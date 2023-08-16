//https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

public class Kadans_Algorithm {
    public static void main(String[] args) {
        int[] arr = new int[] { 9, 1, 4, -2, 3, 0, 5, 9, -2, 2, 7 };
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    public static long maxSubarraySum(int arr[], int n) {
        long maxSum = Integer.MIN_VALUE, sum = 0;
        // Your code here
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] >= sum)
                sum += arr[i];
            else {
                maxSum = sum;
                sum = 0;
            }
        }
        return (maxSum > sum) ? maxSum : sum;

    }
}
