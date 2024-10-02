import java.util.Arrays;

public class MaxFrequency {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 6, 6};
        System.out.println(maxFrequencyTwoPointer(nums, 2));
    }

    // Two pointer
    static int maxFrequencyTwoPointer(int[] nums, int k) {
        // Sorting array
        Arrays.sort(nums);

        int currSum = 0;
        int maxFrequency = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            currSum += nums[right];

            if (currSum + k < (long) nums[right] * (right - left + 1)) {
                currSum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }
        return maxFrequency;
    }
}
