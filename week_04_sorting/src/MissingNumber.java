public class MissingNumber {
    // https://leetcode.com/problems/missing-number/description/
    // Topic: Array + Hash Table + Math + Binary Search + Bit Manipulation + Sorting
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {0, 1, 3}));
    }

    static int missingNumber(int[] nums) {
        // Implement of cyclic sort
        int i = 0;

        while (i < nums.length) {
            int correct = nums[i];

            if (correct < nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return nums.length;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
