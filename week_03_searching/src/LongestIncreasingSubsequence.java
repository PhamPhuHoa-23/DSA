public class LongestIncreasingSubsequence {
    // https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=problem-list-v2&envId=binary-search&difficulty=EASY%2CMEDIUM

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

    static int lengthOfLIS(int[] nums) {
        // dp[i] = max_j dp[j] + 1 if nums[i] > nums[j] else 1
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxlen = 1;
        for (int i = 0; i < nums.length; i++) {
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }

    static int lengthOfLISver2(int[] nums) {
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }
}
