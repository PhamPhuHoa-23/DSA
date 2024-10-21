import java.util.Arrays;

public class MaximumProductThreeNumber {
    // https://leetcode.com/problems/maximum-product-of-three-numbers/description/
    // Topic: Array + Math + Sorting

    public static void main(String[] args) {

    }

    // [a b c d e f g h i j k]
    // if a b < 0 and |a| |b|> i j

    static int maximumProduct(int[] nums) {
        // Sorting array
        Arrays.sort(nums);

        int n = nums.length;

        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3],
                nums[0] * nums[1] * nums[n - 1]);
    }
}
