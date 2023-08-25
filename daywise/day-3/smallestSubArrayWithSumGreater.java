public class smallestSubArrayWithSumGreater {
    public static void main(String[] args) {
        System.out.println(smallestSubWithSum(new int[] { 1, 4, 45, 6, 0, 19 }, 6, 51)); // 3
        System.out.println(smallestSubWithSum(new int[] { 1, 10, 5, 2, 7 }, 5, 9)); // 1
    }

    public static int smallestSubWithSum(int a[], int n, int x) {
        // int length = 0;
        int start = 0, end = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (end <= start && end < n) {
            while (sum < x) {
                sum += a[end++];
            }
            while (sum > x && start < end) {
                min = Math.min(min, end - start);
                sum -= a[start++];
            }
        }
        return min;
    }
}
