public class RotatedSortedArray
{
    public static void main(String[] args)
    {
//        int nums[] = {4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3};
        int nums[] = {1, 3};
        System.out.println("Pivot: " + findPivot(nums));
        System.out.println("Output: " + search(nums, 10));
    }

    static int search(int[] nums, int target)
    {
        // O(log n) runtime
        int pivot = findPivot(nums);

        if (pivot == -1)
        {
            return binarySearch(0, nums.length - 1, nums, target);
        }

        // Checking target belong to what part then do search in that part
        if (nums[0] <= target)
        {
            return binarySearch(0, pivot - 1, nums, target);
        }
        else
        {
            return binarySearch(pivot, nums.length - 1, nums, target);
        }
    }

    static int binarySearch(int start, int end, int[] nums, int target)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
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

            if (nums[mid] > nums[end])
            {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
