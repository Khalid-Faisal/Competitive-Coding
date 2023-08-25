package week1;

import java.util.Arrays;

public class firstMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 1, 2, 0 })); // 3
        System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 })); // 2
    }
    // Using HashMap
    // But Space Complexity O(N) and Time Complexity O(N)

    // We need Solution Space Complexity O(1) and Time Complexity O(N)

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            int chair = element - 1;
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                if (nums[chair] != element) {
                    // Swap
                    int temp = nums[chair];
                    nums[chair] = nums[i];
                    nums[i] = temp;
                    i--;
                }

            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i])
                return i + 1;
        }
        return nums.length;
    }
}
