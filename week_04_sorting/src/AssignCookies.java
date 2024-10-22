import java.util.Arrays;

public class AssignCookies {
    // https://leetcode.com/problems/assign-cookies/description/
    // Topic: Array + Two Pointer + Greedy + Sorting

    public static void main(String[] args) {

    }

    static int findContentChildren(int[] g, int[] s) {
        // Sorting array
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++; i++; j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
