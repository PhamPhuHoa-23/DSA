import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisapearedInArray {
    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

    static List<Integer> findDisappearNumbers(int[] nums) {
        // Cyclic Sort

        int i = 0;
        while (i < nums.length) {
            int trueIndex = nums[i] - 1;

            if (i != trueIndex && nums[i] != nums[trueIndex]) {
                swap(nums, i, trueIndex);
                continue;
            }
            i++;
        }

        List<Integer> disappearNumbers = new ArrayList<>();
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] != idx + 1) {
                disappearNumbers.add(idx + 1);
            }
        }

        return disappearNumbers;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearNumbers(new int[]{1, 2, 2, 4, 5}).toString());
    }
}
