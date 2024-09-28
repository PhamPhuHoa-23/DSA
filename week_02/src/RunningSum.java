import java.util.Arrays;

public class RunningSum {
    public static int[] runningSum(int[] nums) {
        int length = nums.length;

        int[] arr = new int[length];

        arr[0] = nums[0];
        for (int i = 1; i < length; i++) {
            arr[i] = nums[i] + arr[i - 1];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = runningSum(nums);
        System.out.println(Arrays.toString(result));
    }
}
