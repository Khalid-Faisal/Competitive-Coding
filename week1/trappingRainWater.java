package week1;

//Two Array - leftMax[] and rightMax
//Traverse  1 to n from left and find leftMax
//Traverse  n-1 to 0 from right and find rightMax
// Example : 2 7 5 1 0 6 8 3
// leftMax = [2,7,7,7,7,7,8,8] & rightMax = [8,8,8,8,8,8,8,3]
// Now iterate from 1 to n-1 and get the vacant place
// waterSaved += Math.min(leftMax[i], rightMax[i]) - arr[i];
// i=1 --> min(7,8) - 7 = 0
// i=2 --> min(7,8) - 5 = 2
// i=3 --> min(7,8) - 1 = 6
// i=4 --> min(7,8) - 0 = 7
// i=5 --> min(7,8) - 6 = 1
// i=6 --> min(7,8) - 8 = 0
//                      = 16
public class trappingRainWater {
    public static void main(String[] args) {
        System.out.println(trappingWater(new int[] { 7, 4, 0, 9 }, 4)); // 10
        System.out.println(trappingWater(new int[] { 6, 9, 9 }, 3)); // 0
        // System.out.println(trappingWater(new int[] { 2, 7, 5, 1, 0, 6, 8, 3 }, 8));
        // // 0
    }

    public static long trappingWater(int arr[], int n) {
        long waterSaved = 0;
        // O(N)
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int temp = Math.max(arr[i], leftMax[i - 1]);
            leftMax[i] = temp;
        }
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int temp = Math.max(arr[i], rightMax[i + 1]);
            rightMax[i] = temp;
        }

        for (int i = 1; i < n - 1; i++) {
            waterSaved += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return waterSaved;
    }
}
