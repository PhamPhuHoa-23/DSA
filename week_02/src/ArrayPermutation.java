import java.util.Arrays;

public class ArrayPermutation {
    public static int[] solution(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = nums[nums[i]];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] result = solution(nums);
        System.out.println(Arrays.toString(result));
    }
}
