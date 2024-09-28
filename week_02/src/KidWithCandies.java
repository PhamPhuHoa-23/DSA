import java.util.ArrayList;
import java.util.Arrays;

public class KidWithCandies {
    public static boolean[] kidsWithCandies(int[] candies, int extraCandies) {
        int length = candies.length;
        int maxCandies = 0;

        for (int i = 0; i < length; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }

        boolean[] result = new boolean[length];

        for (int i = 0; i < length; i++) {
            result[i] = (candies[i] + extraCandies >= maxCandies);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        System.out.println(Arrays.toString(kidsWithCandies(candies, extraCandies)));
    }
}
