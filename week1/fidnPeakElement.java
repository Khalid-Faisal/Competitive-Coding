package week1;

// Case 1: First Element can be peak if Second element < first Element
// Case 2: Last Element can be peak if Second last element < last Element
// Case 3: Apply binary Seach -> If(a[mid] < a[mid+1]), high thing done! 
// It is possibilty that a[mid+1] can be peak element if(a[mid+2] < a[mid+1])
public class fidnPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 })); // 2 index
        System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 })); // 1 or 5
        System.out.println(findPeakElement(new int[] { 5 })); // 0
        System.out.println(findPeakElement(new int[] { 1, 2, 3 })); // 2
    }

    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int findPeakElementBruteForce(int[] nums) {
        int res = 0;
        if (nums.length == 1)
            return 0;
        else if (nums.length == 2)
            return (nums[0] > nums[1]) ? 0 : 1;
        if (nums[0] > nums[1])
            res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                res = i;
                break;
            }
        }
        if (res == 0 && nums[nums.length - 1] > nums[0])
            res = nums.length - 1;
        return res;
    }
}
