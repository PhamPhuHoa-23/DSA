import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDiffirence {
    // https://leetcode.com/problems/minimum-absolute-difference/description/

    public static void main(String[] args) {
        System.out.println(minimumAbsDiffirence(new int[] {4, 2, 1, 3}).toString());
    }

    static ArrayList<ArrayList<Integer>> minimumAbsDiffirence(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Sort array
        Arrays.sort(arr);

        // Find the minimum distance
        int minDiffirence = findMinDiffirence(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiffirence) {
                ArrayList<Integer> subRes = new ArrayList<>();
                subRes.add(arr[i]);
                subRes.add(arr[i + 1]);
                res.add(subRes);
            }
        }
        return res;
    }

    static int findMinDiffirence(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int minDiff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            int currDiff = arr[i + 1] - arr[i];
            if (currDiff < minDiff) {
                minDiff = currDiff;
            }
        }

        return minDiff;
    }
}
