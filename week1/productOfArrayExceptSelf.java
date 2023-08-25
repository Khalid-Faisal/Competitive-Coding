package week1;

import java.util.Arrays;

public class productOfArrayExceptSelf {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4
        // })));
        System.out.println(Arrays.toString(productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));
        // System.out.println(Arrays.toString(productExceptSelf(new int[] { 2, 0, 5, 0,
        // 1, 1 })));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        System.out.println("res : " + Arrays.toString(res));
        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            System.out.print("res[" + i + "] *= right :  " + res[i] + " *= " + right + " : ");
            res[i] *= right;
            System.out.println(res[i]);
            System.out.print("right *= nums[" + i + "]  :  " + right + " *= " + nums[i] + " : ");
            right *= nums[i];
            System.out.println(right);
            System.out.println();
        }
        return res;
    }
}
