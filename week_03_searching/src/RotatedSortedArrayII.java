public class RotatedSortedArrayII {
    public static void main(String[] args) {
//        int nums[] = {4, 4, 4, 5, 5, 1, 1, 1, 1, 3, 4}; // Pivot: 6
//        int nums[] = {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int nums[] = {1};
        System.out.println("Pivot: " + findPivotV2(nums));
        System.out.println(search(nums, 2));
    }

    static boolean search(int[] nums, int target) {
        int pivot = findPivotV2(nums);

        if (pivot == -1) {
            return binarySearch(0, -1, nums, target);
        }

        // Checking target can show up at which part of array
        if (target >= nums[0]) {
            return binarySearch(0, pivot - 1, nums, target);
        }
        else {
            return binarySearch(pivot, -1, nums, target);
        }
    }

    static boolean binarySearch(int start, int end, int[] nums, int target) {
        if (end == -1) {
            end = nums.length - 1;
        }

        while (start <= end) {
            int mid = (end - start) / 2 + start;

            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }

    static int findPivotV2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > start && nums[mid] < nums[mid - 1]) {
                // This is Pivot
                return mid;
            }

            if (mid < end && nums[mid] > nums[mid + 1]) {
                // This is Pivot
                return mid + 1;
            }

            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && nums[start] > nums[start + 1]) {
                    return start + 1;
                }
                start++;

                // check whether end is pivot
                if (end > start && nums[end] < nums[end - 1]) {
                    return end;
                }
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
