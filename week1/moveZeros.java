package week1;

import java.util.Arrays;

public class moveZeros {
    public static void main(String[] args) {
        // int[] arr = new int[] { 0, 1, 0, 0, 2 };
        // int[] arr = new int[] { 0, 1, 0, 3, 12 };
        int[] arr1 = new int[] { 0 };
        int[] arr2 = new int[] { 1, 5, 0, 4 };
        System.out.println("[Before] Function Call " + Arrays.toString(arr1));
        moveZeroes(arr1);
        System.out.println("[After] Function Call " + Arrays.toString(arr1));

        System.out.println("[Before] Function Call " + Arrays.toString(arr2));
        moveZeroes(arr2);
        System.out.println("[After] Function Call " + Arrays.toString(arr2));
    }

    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                if (k != i)
                    nums[i] = 0;
                k++;
            }
        }
    }
}