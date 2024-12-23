public class PeakElement {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 2, 1};
        System.out.println(findPeakElement(nums));
    }

    // You can imagine the array have height and it look like
    // a mountain. And we need to find the highest point. That's all
    // GOOD LUCK TO YOU

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}
