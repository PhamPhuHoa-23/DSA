import java.util.Arrays;

public class HeightChecker {
    // https://leetcode.com/problems/height-checker/description/

    public static void main(String[] args) {

    }

    static int heightChecker(int[] heights) {
        int[] orderHeights = heights.clone();

        Arrays.sort(orderHeights);

        int diffCount = 0;
        for (int i = 0; i < orderHeights.length; i++) {
            if (orderHeights[i] != heights[i]) {
                diffCount++;
            }
        }

        return diffCount;
    }
}
