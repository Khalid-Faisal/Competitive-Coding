package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumII {
    public static void main(String[] args) {
        List<List<Integer>> res1 = combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        for (int i = 0; i < res1.size(); i++) {
            System.out.println(res1.get(i).toString());
        }
        System.out.println();
        res1 = combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5);
        for (int i = 0; i < res1.size(); i++) {
            System.out.println(res1.get(i).toString());
        }
    }

    public static void helper(int[] arr, int i, List<List<Integer>> result, ArrayList<Integer> subset, int sum,
            int target) {
        if (sum == target) {
            result.add(new ArrayList<>(subset));
            subset = new ArrayList<>();
            return;
        }
        if (sum > target)
            return;
        if (i >= arr.length)
            return;

        subset.add(arr[i]);
        sum += arr[i];
        helper(arr, i + 1, result, subset, sum, target);
        subset.remove(Integer.valueOf(arr[i]));
        sum -= arr[i];

        while (i + 1 < arr.length && arr[i] == arr[i + 1])
            i++;
        helper(arr, i + 1, result, subset, sum, target);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, result, list, 0, target);

        return result;
    }
}
