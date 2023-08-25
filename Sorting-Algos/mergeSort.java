import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        // int[] arr = new int[] { 4, 2, 8, 3, 5, 10 };
        int[] arr = new int[] { 7, 2, 5, 1, 3, 8 };
        System.out.println("[Before Sorting] Arrays : " + Arrays.toString(arr));
        mergesort(arr, 0, arr.length - 1);
        System.out.println("[After Sorting] Arrays : " + Arrays.toString(arr));
    }

    public static void mergesort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
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
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}
