import java.util.Arrays;
import java.util.HashSet;

public class longestConsecutiveSubsequence {
    public static void main(String[] args) {
        System.out.println(findLongestConseqSubseq(new int[] { 2, 6, 1, 9, 4, 5, 3 }, 7)); // 6
        System.out.println(findLongestConseqSubseq(new int[] { 1, 9, 3, 10, 4, 20, 2 }, 7)); // 4
        System.out.println(findLongestConseqSubseq(new int[] { 34, 2, 7, 23, 31, 38, 13, 11, 37, 19, 45, 6 }, 12)); // 2
        System.out.println(findLongestConseqSubseq(new int[] { 4 }, 1)); // 1
        System.out.println(findLongestConseqSubseq(new int[] { 2, 0, 1, 1, 4 }, 5)); // 3
        System.out.println(findLongestConseqSubseq(
                new int[] { 42, 37, 35, 14, 17, 10, 50, 20, 44, 13, 4, 33, 12, 28, 7,
                        36, 46, 22, 26, 21, 47, 18, 31, 2, 5, 34, 9, 45, 16, 32, 48, 19, 11, 29, 27, 39, 8, 49, 43 },
                39)); // 9
    }

    // https://www.youtube.com/watch?v=oO5uLE7EUlM
    public static int findLongestConseqSubseq(int arr[], int N) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            set.add(arr[i]);
        }
        for (Integer element : set) {
            // Checking if element is first in consecutive list
            if (!set.contains(element - 1)) {
                int count = 1;
                int x = element;
                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static int findLongestConseqSubseqBruteForce(int arr[], int N) {
        int count = 0, longest = 0;
        Arrays.sort(arr);
        System.out.println("Sorted Array : " + Arrays.toString(arr));
        for (int i = 0; i < N - 1; i++) {

            if (arr[i] == arr[i + 1])
                continue;
            if (arr[i] == arr[i + 1] - 1) {
                count++;
            } else {
                if (longest < count)
                    longest = count;
                count = 1;
            }
        }
        return (count < longest) ? longest : count;
    }
}