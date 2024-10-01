public class Search2dMatrix {
    // https://leetcode.com/problems/search-a-2d-matrix/description/

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 11));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        // row[i + 1] > row[i]
        // col[i + 1] > col[i]

        // Write in O(log(m * n)) = O(log m + log n) hehe

        // Binary search in 2D

        // Find the row that maybe contain target
        int startRow = 0;
        int endRow = matrix.length - 1;

        if (target < matrix[startRow][0] || target > matrix[endRow][matrix[endRow].length - 1]) {
            return false;
        }

        while (startRow <= endRow) {
            int midRow = startRow + (endRow - startRow) / 2;

            if (matrix[midRow][0] > target) {
                endRow = midRow - 1;
            }
            else if (matrix[midRow][0] < target) {
                startRow = midRow + 1;
            }
            else {
                return true;
            }
        }

        int chosenRow = endRow;

        // Do binary search on this row
        int start = 0, end = matrix[chosenRow].length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[chosenRow][mid] == target) {
                return true;
            }
            else if (matrix[chosenRow][mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return false;
    }
}
