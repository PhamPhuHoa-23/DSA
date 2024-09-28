public class MinimumRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {1};
        System.out.println(findPivotWithDuplicates(nums));
    }

    public static int findMin(int[] nums) {
        return nums[findPivotWithDuplicates(nums)];
    }

    static int findPivotWithDuplicates(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                // This is example [4, ?, ?, 4, 4, 4, 4] or [4, 4, 4, 4, ?, ?, 4]
                // Check start is Pivot or not
                if (start < nums.length - 1 && nums[start] > nums[start + 1]) {
                    return start + 1;
                }

                // Check end is Pivot or not
                if (end > 0 && nums[end] < nums[end - 1]) {
                    return end;
                }

                // Skip the duplicate part
                start++;
                end--;
            }
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
