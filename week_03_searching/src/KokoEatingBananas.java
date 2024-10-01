import java.util.Arrays;
import java.util.OptionalInt;

public class KokoEatingBananas {
    // https://leetcode.com/problems/koko-eating-bananas/description/

    public static void main(String[] args) {
        int[] piles = {1, 1, 1, 999999999};
        int h = 10;
        System.out.println(minEatingSpeed(piles, h));
    }

    static int findMaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele: arr) {
            max = Math.max(max, ele);
        }
        return max;
    }

    static int minEatingSpeed(int[] piles, int h) {
        long result = Integer.MAX_VALUE;

        long start = 1;
        long end = findMaxValue(piles);

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long hours = findEatingHours(piles, mid);
            if (hours > h) {
                // An qua cham
                // Khong thoa de bai
                start = mid + 1;
            }
            else if (hours <= h) {
                // An qua nhanh
                // Giam toc do an
                end = mid - 1;
                result = Math.min(result, mid);
            }
            // else {
            //     result = Math.min(result, mid);
            // }
        }
        return (int) result;
    }

    static long findEatingHours(int [] piles, long speed) {
        long hours = 0;
        for (int banana: piles) {
            double hour = (double) banana / speed;
            if (hour < 1) {
                hours += 1;
            }
            else if (hour == (int) hour) {
                hours += (int) hour;
            }
            else {
                hours += (int) hour + 1;
            }
        }
        return hours;
    }
}
