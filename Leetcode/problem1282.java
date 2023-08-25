package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem1282 {
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[] { 3, 3, 3, 3, 3, 1, 3 }).toString());
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < groupSizes.length; ++i) {
            List<Integer> list = groups.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            list.add(i);
            if (list.size() == groupSizes[i]) {
                res.add(list);
                groups.put(groupSizes[i], new ArrayList<>());
            }
        }
        return res;
    }
}
