import java.util.Arrays;

public class floodFillOfPixel {
    public static void main(String[] args) {
        int[][] res = floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        // System.out.println(floodFill(new int[][]{{0,0,0},{0,0,0}}, 0, 0, 0));
    }

    public static void helper(int[][] image, int x, int y, int color, int oldColor, int r, int c) {
        if (x < 0 || y < 0 || x >= r || y >= c || image[x][y] != oldColor)
            return;

        image[x][y] = color;
        helper(image, x + 1, y, color, oldColor, r, c);
        helper(image, x - 1, y, color, oldColor, r, c);
        helper(image, x, y + 1, color, oldColor, r, c);
        helper(image, x, y - 1, color, oldColor, r, c);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color != image[sr][sc])
            helper(image, sr, sc, color, image[sr][sc], image.length, image[0].length);
        return image;
    }
}
