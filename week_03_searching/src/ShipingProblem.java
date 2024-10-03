public class ShipingProblem {
    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights, 5));
    }

    static int shipWithinDays(int[] weights, int days) {
        // Same with problem split array into days part for minimize sum of subarray

        // We do binary search
        // We need to find minSum and maxSum
        int minSum = weights[0];
        int maxSum = weights[0];

        for (int i = 1; i < weights.length; i++) {
            minSum = Math.max(minSum, weights[i]);
            maxSum += weights[i];
        }

        while (minSum <= maxSum) {
            int midSum = minSum + (maxSum - minSum) / 2;

            int subArrSum = 0;
            int subArrCounter = 1;
            for (int i = 0; i < weights.length; i++) {
                // Tinh so sub array co the chia duoc
                subArrSum += weights[i];

                if (subArrSum > midSum) {
                    subArrSum = weights[i];
                    subArrCounter++;
                }
            }
            if (subArrCounter <= days) {
                maxSum = midSum - 1;
            } else {
                minSum = midSum + 1;
            }
        }
        return minSum;
    }
}
