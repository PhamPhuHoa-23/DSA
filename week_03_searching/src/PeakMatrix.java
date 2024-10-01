import java.awt.desktop.AboutEvent;

public class PeakMatrix {
    // https://leetcode.com/problems/find-a-peak-element-ii/

    public static void main(String[] args) {
        int[][] mat = {
                {70, 50, 40, 30, 20},
                {100, 1, 2, 3, 4}
        };
        System.out.println(findPeakGrid(mat));
    }

    static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Hint 1: Let's assume that the width of the array
        // is bigger than the height, otherwise, we will split
        // in another direction.

        // Hint 2: Split the array into three parts: central
        // column left side and right side.
        int startCol = 0;
        int endCol = n - 1;

        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            int maxRow = 0;

            for (int rowIdx = 1; rowIdx < m; rowIdx++) {
                // Hint 3: Go through the central column and two
                // neighbor columns and look for maximum.
                maxRow = (mat[rowIdx][midCol] >= mat[maxRow][midCol]) ? rowIdx : maxRow;
            }

            // Hint 4: If it's in the central column - this is our peak.
            boolean isGreaterLeft = (midCol - 1 >= startCol) && (mat[maxRow][midCol - 1] > mat[maxRow][midCol]);
            boolean isGreaterRight = (midCol + 1 <= endCol) && (mat[maxRow][midCol + 1] > mat[maxRow][midCol]);

            if (!isGreaterLeft && !isGreaterRight) {
                return new int[] {maxRow, midCol};
            }

            // Hint 5: If it's on the left side, run this algorithm
            // on subarray left_side + central_column.
            else if (isGreaterRight) {
                startCol = midCol + 1;
            }
            // Hint 6: If it's on the right side, run this algorithm
            // on subarray right_side + central_column
            else {
                endCol = midCol - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
