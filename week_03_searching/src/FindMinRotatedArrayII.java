public class FindMinRotatedArrayII {
    public static void main(String[] args) {
        System.out.println(findPivot(new int[] {3,1,1,1,1,1}));
    }

    static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return nums[pivot];
    }

    static int findPivot(int[] nums)
    {
        // This function is use to find the start_idx of second asc sub-array
        int start = 0;
        int end = nums.length - 1;

        while (start < end)
        {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1])
            {
                return mid + 1;
            }

            if (mid > 0 && nums[mid] < nums[mid - 1])
            {
                return mid;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if (start < end && nums[start] > nums[start + 1]) {
                    return start + 1;
                }
                start++;

                if (start < end && nums[end - 1] > nums[end]) {
                    return end;
                }
                end--;
            } else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
