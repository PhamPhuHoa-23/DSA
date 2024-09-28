public class MaxValueOfEquation
{
    public static void main(String[] args) {
//        int[][] testArray = {
//                {1, 3},
//                {2, 0},
//                {5, 10},
//                {6, -10},
//        };

        int[][] testArray = {
                {0, 0},
                {3, 0},
                {9, 2},
        };

        int k = 3;
        System.out.println("Output: " + findMaxValueOfEquation(testArray, k));
    }

    public static int findMaxValueOfEquation(int[][] points, int k)
    {
        int pointLength = points.length;

        // Initialize array for storing maximum value
        int[] maxValueArray = new int[pointLength];
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < pointLength; i++)
        {
            for (int j = i + 1; j < pointLength; j++)
            {
                int distance = Math.abs(points[i][0] - points[j][0]);
                if (distance <= k)
                {
                    maxValue = Math.max(points[i][1] + points[j][1] + distance, maxValue);
                }
            }
        }

        return maxValue;
    }
}
