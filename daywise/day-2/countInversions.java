public class countInversions {
    public static void main(String[] args) {
        System.out.println(inversionCount(new int[] { 2, 4, 1, 3, 5 }, 5)); // 3
        System.out.println(inversionCount(new int[] { 2, 3, 4, 5, 6 }, 5)); // 0
        System.out.println(inversionCount(new int[] { 10, 10, 10 }, 3)); // 0
    }

    public static long inversionCount(int arr[], int N) {
        return mergeSortAndCount(arr, 0, N - 1);
    }

    // O(n^2)
    /*
     * public static long inversionCount(long arr[], long N) {
     * long count = 0;
     * for (int i = 0; i < N; i++) {
     * for (int j = i; j < N; j++) {
     * if (arr[i] > arr[j] && i < j)
     * count++;
     * }
     * }
     * return count;
     * }
     */
    public static long mergeSortAndCount(int[] arr, int low, int high) {
        long swaps = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            swaps += mergeSortAndCount(arr, low, mid);
            swaps += mergeSortAndCount(arr, mid + 1, high);

            swaps += merge(arr, low, mid, high);
        }
        return swaps;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[low + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + i + 1];
        }

        // Merge Left and Right Array
        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                count += (mid + 1) - (low + i);
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
        return count;
    }
}
