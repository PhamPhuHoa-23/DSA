import java.util.Arrays;

public class LargestPerimeterTriangle {
    // https://leetcode.com/problems/largest-perimeter-triangle/description/
    // Topic: Array + Math + Greedy + Sorting

    public static void main(String[] args) {

    }

    static int largestPerimeter(int[] nums) {
        // Sort array
        // [a b c d e f g h i j k l m n o p]
        // It obviously that p + o > m and p + n > o
        // We just need to check if m + o > p
        // If it is -> return
        // If it don't p--

        Arrays.sort(nums);

        int i = nums.length - 1;
        while (i >= 2) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            } else {
                i--;
            }
        }
        return 0;
    }
}
