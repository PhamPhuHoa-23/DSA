import java.util.Arrays;

public class NonIntervalOverlap {
    // https://leetcode.com/problems/non-overlapping-intervals/description/?fbclid=IwZXh0bgNhZW0CMTAAAR3zH1iLZJqGBc1hkBjkFUMJ66_Yl4ydEfGFeMG8O1gNn8JZyvl1qY0sZ-A_aem_BdVzvIrgRS7fjEBc2Y-whQ

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][] {
                {-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}
        }));
    }

    static void quickSort(int[][] intervals, int start, int end) {
        if (start >= end) {
            return;
        }

        int s = start;
        int e = end;
        int m = s + (e - s) / 2;
        int[] pivot = intervals[m].clone();

        while (s <= e) {
            while (intervals[s][0] < pivot[0] || (intervals[s][0] == pivot[0] && intervals[s][1] < pivot[1] )) {
                s++;
            }

            while (intervals[e][0] > pivot[0] || (intervals[e][0] == pivot[0] && intervals[e][1] > pivot[1] )) {
                e--;
            }

            if (s <= e) {
                hyperSwap(intervals, s, e);
                s++;
                e--;
            }
        }

        quickSort(intervals, start, e);
        quickSort(intervals, s, end);
    }

    static void hyperSwap(int[][] intervals, int i, int j) {
        int[] temp = intervals[i].clone();
        intervals[i][0] = intervals[j][0];
        intervals[i][1] = intervals[j][1];
        intervals[j][0] = temp[0];
        intervals[j][1] = temp[1];
    }

    static int eraseOverlapIntervals(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);

        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));
        }

        int lower = intervals[0][0];
        int upper = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == lower || intervals[i][0] < upper) {
                count++;
            } else {
                lower = intervals[i][0];
                upper = intervals[i][1];
            }
        }

        return count;
    }
}
