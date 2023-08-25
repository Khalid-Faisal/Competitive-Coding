package week1;

public class searchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 8, 0, 1, 2 }, 0)); // 5
        System.out.println(search(new int[] { 4, 5, 6, 7, 8, 0, 1, 2 }, 3)); // 5
        System.out.println(search(new int[] { 2, 3, 4, 1 }, 0)); // -1
        System.out.println(search(new int[] { 1, 3, 5 }, 0)); // -1
        System.out.println(search(new int[] { 1, 3, 5 }, 5)); // 2
        System.out.println(search(new int[] { 1, 3, 5 }, 3)); // 1
        System.out.println(search(new int[] { 3, 5, 1 }, 3)); // 0
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, pivot = 0;
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high])
                high = mid;
            else
                low = mid + 1;
        }
        pivot = low;

        if (target == nums[0])
            return 0;
        else if (target == nums[nums.length - 1])
            return nums.length - 1;

        if (target < nums[0]) {
            low = pivot;
            high = nums.length - 1;
        } else {
            low = 0;
            if (pivot == 0 && nums.length > 1)
                high = nums.length - 1;
            else
                high = pivot;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
