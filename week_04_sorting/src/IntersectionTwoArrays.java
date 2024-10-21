import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionTwoArrays {
    // https://leetcode.com/problems/intersection-of-two-arrays/description/
    // Topic: Array + Hash Table + Two Pointers + Binary Search + Sorting

    public static void main(String[] args) {

    }

    static int[] intersection(int[] a, int[] b) {
        // Ensure we choose a is a array that has smaller size
        if (a.length > b.length) {
            return intersection(b, a);
        }

        // Sorting 2 arrays O(n logn)
        Arrays.sort(a);
        Arrays.sort(b);

        // Loops for element in a
        // Using Binary Search to find it has in b or not
        HashSet<Integer> duplicateSet = new HashSet<>();
        for (int target: a) {
            if (binarySearch(b, target)) {
                duplicateSet.add(target);
            }
        }

        return duplicateSet.stream().mapToInt(i -> i).toArray();
    }

    static boolean binarySearch(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;

            if (a[mid] == target) {
                return true;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
