import java.util.HashMap;

public class MajorityElement {
    // https://leetcode.com/problems/majority-element/description/
    // Topic: Array + Hash Table + Divide and Conquer + Sorting + Counting
    public static void main(String[] args) {

    }

    static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
}
