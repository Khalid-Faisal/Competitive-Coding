import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        // int[] arr = new int[] { 4, 2, 8, 3, 5, 10 };
        int[] arr = new int[] { 7, 2, 5, 1, 3, 8 };
        System.out.println("[Before Sorting] Arrays : " + Arrays.toString(arr));
        bubblesort(arr, 0, arr.length - 1);
        System.out.println("[After Sorting] Arrays : " + Arrays.toString(arr));
    }

    public static void bubblesort(int[] arr, int low, int high) {
        for (int i = 0; i < high; i++) {
            for (int j = i; j < high; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
