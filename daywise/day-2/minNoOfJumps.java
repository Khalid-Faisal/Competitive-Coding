
public class minNoOfJumps {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 })); // 3
        System.out.println(minJumps(new int[] { 1, 4, 3, 2, 6, 7 })); // 2
        System.out.println(minJumps(new int[] { 2, 1, 1, 0, 5, 1 })); // -1
        System.out.println(minJumps(new int[] { 2, 2, 5, 1, 2, 1, 1 })); // -1
    }

    public static int minJumps(int[] arr) {
        int jumps = 0, farthest = 0, current = 0;
        if (arr[0] == 0)
            return -1;
        for (int i = 0; i < arr.length - 1; i++) {
            farthest = Math.max(farthest, arr[i] + i);
            if (current == i) {
                current = farthest;
                jumps++;
            }
            if (arr[i] == 0 && i == farthest)
                return -1;
        }

        return jumps;
    }
}
