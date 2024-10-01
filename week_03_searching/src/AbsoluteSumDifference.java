import java.util.Arrays;

public class AbsoluteSumDifference {
    // https://leetcode.com/problems/minimum-absolute-sum-difference/description/

    public static void main(String[] args) {
        int[] nums1 = {1,10,4,4,2,7};
        int[] nums2 = {9,3,5,1,7,4};

        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        // Topic: Array - Binary Search - Sorting - Ordered Set

        // Hint 1: Go through each element and test the optimal replacements

        // Hint 2: There are 2 only possible replacements for each element
        // (higher or lower) that are optimal

        // Make a copy of nums1 and sort it
        int[] snums1 = nums1.clone();
        Arrays.sort(snums1);

        int maxDiff = 0;
        int bestPosistion = -1;
        int valueForReplace = -1;


        // For each n2 in nums2:
        // // Calculate the ab diff at the current position
        // // Using binary search on snums1, find
        // // // The largest ele <= n2
        // // // The smallest ele >= n2
        for (int i = 0; i < nums2.length; i++) {
            int n2 = nums2[i];
            int currDiff = Math.abs(nums1[i] - n2);

            int bestGreater = findBestGreaterValue(snums1, n2);
            int bestSmaller = findBestSmallerValue(snums1, n2);

            if (bestGreater != -1) {
                int newDiff = Math.abs(bestGreater - n2);
                int diffOfDiff = currDiff - newDiff;

                if (diffOfDiff > maxDiff) {
                    bestPosistion = i;
                    valueForReplace = bestGreater;
                    maxDiff = diffOfDiff;
                }
            }

            if (bestSmaller != -1) {
                int newDiff = Math.abs(bestSmaller - n2);
                int diffOfDiff = currDiff - newDiff;

                if (diffOfDiff > maxDiff) {
                    bestPosistion = i;
                    valueForReplace = bestSmaller;
                    maxDiff = diffOfDiff;
                }
            }
        }


        // If we found a better nums1 value, replace the
        // original value with the better value
        if (bestPosistion != -1) {
            nums1[bestPosistion] = valueForReplace;
        }

        int absoluteSum = 0;
        for (int i = 0; i < nums1.length; i++) {
            absoluteSum += Math.abs(nums1[i] - nums2[i]);
        }

        return absoluteSum;
    }

    static int findBestGreaterValue(int[] nums, int target) {
        // nums is a sorted array
        int start = 0, end = nums.length - 1;
        if (target > nums[end]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return nums[start];
    }

    static int findBestSmallerValue(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        if (target < nums[start]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return nums[end];
    }
}
