import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    // https://leetcode.com/problems/merge-intervals/description/

    public static void main(String[] args) {
        // pass
    }

    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int lower = intervals[0][0];
        int upper = intervals[0][1];

        ArrayList<int[]> res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= upper) {
                upper = Math.max(upper, intervals[i][1]);
            } else {
                int[] tmp = new int[] {lower, upper};
                res.add(tmp);
                lower = intervals[i][0];
                upper = intervals[i][1];
            }
        }

        res.add(new int[] {lower, upper});

        int[][] formatRes = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            formatRes[i] = res.get(i);
        }
        return formatRes;
    }
}
