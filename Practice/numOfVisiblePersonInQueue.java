package Practice;

import java.util.Arrays;
import java.util.Stack;

public class numOfVisiblePersonInQueue {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(canSeePersonsCount(new int[] { 10, 6, 8, 5, 11, 9 })));
    }

    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int h = heights[i];

            while (!stack.isEmpty() && stack.peek()[0] < h) {
                int prev = stack.pop()[1];
                result[prev]++;
            }

            if (!stack.isEmpty())
                result[stack.peek()[1]]++;

            stack.push(new int[] { h, i });
        }
        return result;
    }
}
