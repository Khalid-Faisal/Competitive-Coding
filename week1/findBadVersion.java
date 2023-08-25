package week1;

public class findBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static boolean isBadVersion(int n) {
        if (n <= 4)
            return false;
        return true;
    }

    public static int firstBadVersion(int n) {
        int low = 0, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid))
                high = mid;
            else
                low = mid + 1;

        }
        if (low == high && isBadVersion(low))
            return low;
        return -1;
    }
}
