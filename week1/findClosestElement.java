package week1;

import java.util.ArrayList;
import java.util.List;

public class findClosestElement {
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3).toString());
        System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1).toString());
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                low = mid + 1;
            else
                high = mid;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(arr[low + i]);
        }
        return result;
    }
}
