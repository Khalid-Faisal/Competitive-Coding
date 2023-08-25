package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumSolution {
    public static void main(String[] args) {
        List<List<Integer>> res1 = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        for (int i = 0; i < res1.size(); i++) {
            System.out.println(res1.get(i).toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[low], nums[high], -sum));
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
