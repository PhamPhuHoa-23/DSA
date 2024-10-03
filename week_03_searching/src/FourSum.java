import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {2,4,0,4,-3,-3};
        System.out.println(fourSum(nums, 0).toString());
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        // Sorting
        Arrays.sort(nums);

        // Storing results
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        // O(n^4) to O(n^3 + nlog n)
        for (int firstIdx = 0; firstIdx < nums.length; firstIdx++) {
            if (firstIdx > 0 && nums[firstIdx] == nums[firstIdx - 1]) {
                continue;
            }
            for (int secondIdx = nums.length - 1; secondIdx < nums.length && secondIdx > firstIdx; secondIdx--) {
                if (secondIdx < nums.length - 1 && nums[secondIdx] == nums[secondIdx + 1]) {
                    continue;
                }
                long twoSumTarget = (long) target - nums[firstIdx] - nums[secondIdx];

                ArrayList<ArrayList<Integer>> positions = findAllTwoSum(nums, firstIdx + 1, secondIdx - 1, twoSumTarget);

                for (ArrayList<Integer> position : positions) {
                    results.add(position);
                }
            }
        }
        return results;
    }

    public static ArrayList<ArrayList<Integer>> findAllTwoSum(int[] nums, int start, int end, long target) {
        ArrayList<ArrayList<Integer>> allResults = new ArrayList<>();
        int veryFirst = start - 1;
        int verySecond = end + 1;
        while (start < end) {
            long total = (long) nums[start] + nums[end];
            if (total == target) {
                allResults.add(new ArrayList<>(Arrays.asList(nums[veryFirst], nums[start], nums[end], nums[verySecond])));
                start++;
                while (start <= end && nums[start] == nums[start - 1]) {
                    start += 1;
                }
                end--;
                while (start <= end && nums[end] == nums[end + 1]) {
                    end -= 1;
                }
            }
            else if (total > target) {
                end -= 1;
                while (start <= end && nums[end] == nums[end + 1]) {
                    end -= 1;
                }
            }
            else {
                start += 1;
                while (start <= end && nums[start] == nums[start - 1]) {
                    start += 1;
                }
            }
        }
        return allResults;
//        return new int[]{-1, -1};
    }
}
