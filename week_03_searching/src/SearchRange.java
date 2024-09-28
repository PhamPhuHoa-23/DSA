import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        int arr[] = {5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 10, 11, 11};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    static int[] searchRange(int[] nums, int target) {
        // Have to do Binary Search because
        // "You must write an algorithm with O(log n)
        // runtime complexity"
        int start = 0, end = nums.length - 1;

        while (
                start <= end
        ) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                if (nums[start] != target) {
                    start += 1;
                }
                else if (nums[end] != target) {
                    end -= 1;
                }
                else {
                    return new int[]{start, end};
                }
            }
        }

        // Doesn't exist
        return new int[] {-1, -1};
    }
}
