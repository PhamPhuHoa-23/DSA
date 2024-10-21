import java.util.Arrays;

public class LargestNumber {
    // https://leetcode.com/problems/largest-number/description/
    // Topic: Array + GD + S + String
    public static void main(String[] args) {

    }

    static int getNumberLength(int num) {
        int length = 0;
        while (num > 0) {
            length += 1;
            num /= 10;
        }
        return length;
    }

    static String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));
        if (numsStr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String numStr : numsStr) {
            result.append(numStr);
        }

        return result.toString();
    }
}
