package week1;

public class removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] { 1, 2, 2, 3 }));
        System.out.println(removeDuplicates(new int[] { 1, 2, 2 }));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                count++;
            else
                nums[i - count] = nums[i];
        }
        return nums.length - count;
    }
}