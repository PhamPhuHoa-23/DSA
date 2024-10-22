import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionTwoArrayII {
    // https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
    // Topic: Array + Hash Table + Two Pointers + Binary Search + Sorting

    public static void main(String[] args) {

    }

    static int[] intersect(int[] nums1, int[] nums2) {
        // Sort two array O(n logn)
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        ArrayList<Integer> intersectionList = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersectionList.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return intersectionList.stream().mapToInt(x -> x).toArray();
    }
}
