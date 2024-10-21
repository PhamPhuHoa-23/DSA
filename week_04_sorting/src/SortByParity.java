import java.util.Arrays;

public class SortByParity {
    // https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/07-sorting.md

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity2(new int[] {1, 3, 2, 4})));
    }

    static int[] sortArrayByParity2(int[] nums) {
        // O (n) approach
        int start = 0;
        int end = nums.length - 1;

        int i = 0;
        while (start <= i && i <= end) {
            if (nums[i] % 2 == 0) {
                swap(nums, start, i);
                start += 1;
                i += 1;
            } else {
                swap(nums, i, end);
                end -= 1;
            }
        }
        return nums;
    }

    static int[] sortArrayByParity(int[] nums) {
        // I will use bubble sort
        // O (n^2)

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if ((nums[j] & 1) == 1 && (nums[j + 1] & 1) == 0) {
                    swap(nums, j, j + 1);
                }
            }
        }

        return nums;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
