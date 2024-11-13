import java.sql.Array;
import java.util.Arrays;

public class MinimumSIzeSubArraySum {
    // https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=binary-search&difficulty=EASY%2CMEDIUM

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }

    static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int min_len = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];

            if (sum >= target) {
                sum -= nums[left];
                sum -= nums[right];
                min_len = Math.min(min_len, right - left + 1);
                left++;
            } else {
                right++;
            }
        }

        if (min_len == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min_len;
        }
    }
}
