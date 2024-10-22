import java.util.Arrays;

public class SortByParity2 {
    // https://leetcode.com/problems/sort-array-by-parity-ii/description/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[] {4, 1, 1, 0, 1, 0})));
    }

    static int[] sortArrayByParityII(int[] nums) {
        // Same approach
        // Two pointer -> Point to even index and odd index
        // Traversal through array
        // [a(e) b(o) c(e) d e ..] assume a b c is in correct position
        // d is in odd index
        // if d is odd then swap with itself -> Go to the next element
        // if d is even then swap with e
        // -> [a(e) b(o) c(e) e(?) d(o) -> We need to check this index again
        // because e is unknown

        int evenPointer = 0;
        int oddPointer = 1;
        int currentIndex = 0;

        while (currentIndex < nums.length) {
            if ((currentIndex % 2) == (nums[currentIndex] % 2)) {
                if (currentIndex % 2 == 0 && currentIndex == evenPointer) {
                    evenPointer += 2;
                } else if (currentIndex % 2 == 1 && currentIndex == oddPointer) {
                    oddPointer += 2;
                }
                currentIndex++;
            } else {
                if (nums[currentIndex] % 2 == 0) {
                    // So chan nhung o index le
                    swap(nums, currentIndex, evenPointer);
                    evenPointer += 2;
                } else {
                    swap(nums, currentIndex, oddPointer);
                    oddPointer += 2;
                }
            }
        }
        return nums;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
