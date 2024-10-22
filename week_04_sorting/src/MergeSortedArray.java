import java.util.Arrays;

public class MergeSortedArray {
    // https://leetcode.com/problems/merge-sorted-array/description/

    public static void main(String[] args) {
        merge(
                new int[] {1, 2, 4, 6, 0, 0, 0},
                4,
                new int[] {2, 5, 6},
                3
        );
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        // topic: array + two pointer + sorting

        // hint 1: You can easily solve this problem if you simply
        // think about two elements at a time rather than two arrays.
        // We know that each of the individual arrays is sorted. What
        // we don't know is how they will intertwine. Can we take a
        // local decision and arrive at an optimal solution?

        // hint 2: If you simply consider one element each at a time
        // from the two arrays and make a decision and proceed accordingly,
        // you will arrive at the optimal solution.

        int endNums1 = m - 1;
        int endNums2 = n - 1;
        int endMerge = m + n - 1;

        while (endNums1 >= 0 || endNums2 >= 0) {
            if (endNums1 < 0) {
                nums1[endMerge--] = nums2[endNums2--];
            } else if (endNums2 < 0) {
                nums1[endMerge--] = nums1[endNums1--];
            } else if (nums1[endNums1] > nums2[endNums2]) {
                nums1[endMerge--] = nums1[endNums1--];
            } else {
                nums1[endMerge--] = nums2[endNums2--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
