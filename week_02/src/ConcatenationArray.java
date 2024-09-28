import java.util.Arrays;

public class ConcatenationArray {
    public static int[] getConcatenationArray(int[] nums) {
        int length = nums.length;

        int[] arr = new int[2 * length];
        for (int i = 0; i < length; i++) {
            arr[i] = nums[i];
            arr[i + length] = nums[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] arr = getConcatenationArray(nums);
        System.out.println(Arrays.toString(arr));
    }
}
