package week1;

import java.util.ArrayList;
import java.util.List;

public class findDuplicateElementsInArray {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }).toString());
        System.out.println(findDuplicates(new int[] { 4, 3, 1, 2 }).toString());
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n - 1] > 0)
                nums[n - 1] *= -1;
            else
                res.add(n);
        }
        // if (res.size() == 0)
        // return new ArrayList<>(-1);
        return res;
    }
}
