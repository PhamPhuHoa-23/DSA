public class SingleNonDuplicate {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6};
        System.out.println(singleNonDuplicate(arr));
    }

    static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int numLeftElements = mid - start;
            int numRightElements = end - mid;

            if (nums[mid] == nums[mid - 1] && numLeftElements > 0) {
                // If numLeftElements is odd then the single is on the Right
                // Or can say numRightElement is Odd

                // Intialize real left number
                numLeftElements++;
                if (numLeftElements % 2 != 0) {
                    end = mid;
                }
                else if (numRightElements % 2 != 0){
                    start = mid + 1;
                }
            }
            else if (nums[mid] == nums[mid + 1] && numRightElements > 0) {
                // Intialize right number
                numRightElements++;
                if (numRightElements % 2 != 0) {
                    start = mid;
                }
                else if (numLeftElements % 2 != 0){
                    end = mid - 1;
                }
            }
            else {
                return nums[mid];
            }
        }
        return -1;
    }
}
