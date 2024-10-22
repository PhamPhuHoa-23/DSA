public class ThirdMaximumNumber {
    // https://leetcode.com/problems/third-maximum-number/description/
    // Topic: Array + Sorting
    // Follow up: Can you find an O(n) solution?
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[] {2, 2, 3, 1}));
    }

    static int thirdMax(int[] nums) {
        int max = nums[0];
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] < max) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }
        if (thirdMax == Integer.MIN_VALUE) {
            return max;
        }
        return thirdMax;
    }

}
