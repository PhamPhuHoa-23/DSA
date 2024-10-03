public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIdx = nums[i] - 1;

            if (correctIdx != i && nums[correctIdx] == nums[i]) {
                // We find duplicates
                return nums[i];
            } else if (nums[correctIdx] != nums[i]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }

        }
        return -1;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
