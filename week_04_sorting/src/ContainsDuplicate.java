import java.util.HashSet;

public class ContainsDuplicate {
    // https://leetcode.com/problems/contains-duplicate/description/
    // Topic: Array + Hash table + Sorting

    public static void main(String[] args) {

    }

    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }
}
