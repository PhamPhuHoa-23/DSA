import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class RightInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {3, 4},
                {2, 3},
                {1, 2}
        };
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int[][] transformIntervals = new int[intervals.length][3];
        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            transformIntervals[i][0] = intervals[i][0];
            transformIntervals[i][1] = intervals[i][1];
            transformIntervals[i][2] = i;
        }

        Arrays.sort(transformIntervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < transformIntervals.length; i++) {
            int target = transformIntervals[i][1];

            result[transformIntervals[i][2]] = binarySearch(transformIntervals, target);
        }

        return result;
    }

    static int binarySearch(int[][] intervals, int target) {
        int left = 0, right = intervals.length - 1;

        if (target > intervals[intervals.length - 1][0]) {
            return -1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (intervals[mid][0] == target) {
                return intervals[mid][2];
            }
            else if (intervals[mid][0] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return intervals[left][2];
    }
}
