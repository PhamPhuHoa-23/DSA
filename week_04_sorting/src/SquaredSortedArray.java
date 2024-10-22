import java.util.Arrays;

public class SquaredSortedArray {
    // https://leetcode.com/problems/squares-of-a-sorted-array/description/

    public static void main(String[] args) {

    }

    static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
}
