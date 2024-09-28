import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {1, 3, 7, 9, 100, 276, 876};
        int target = 107;

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int total = nums[start] + nums[end];

            if (total == target) {
                return new int[]{start, end};
            }
            else if (total > target) {
                end -= 1;
            }
            else {
                start += 1;
            }
        }
        return new int[]{-1, -1};
    }
}
