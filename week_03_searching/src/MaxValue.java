public class MaxValue {
    // https://leetcode.com/problems/reach-a-number/description/
    public static void main(String[] args) {
        System.out.println(maxValue(4, 0, 4));
    }

    static int maxValue(int n, int index, int maxSum) {
        // nums.length == n
        // nums[i] > 0
        // Hai so canh nhau thi bang nhau hoac lien tiep nhau
        // sum(nums) <= target
        // nums[index] is maximized

        // Hint 1: What if the problem was instead determining if you could generate a valid array with nums[index] == target?
        // Translate: Thay van de thanh: Tao 1 cai arr du yeu cau sao cho nums[index] = target

        // Hint 2: To generate the array, set nums[index] to target, nums[index - i] to target - i
        // nums[index + i] to target - i. Then, this will give the minimum possible sum, so check if
        // the sum is less then or equal to maxSum

        // Hint 3: n is too large to actually the array, so you can use the formula
        // 1 + 2 + 3 + .. + n = n(n + 1) / 2 to quickly find the sum of [0, ... , index] and [index .. n - 1]


        // Hint 4: Binary search for the target. If it is possible, then move the lower bound up. Otherwise,
        // Otherwise, move the upper bound down
        long start = 1;
        long end = maxSum;
        long result = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long sum = minSum(n, index, mid);
            if (sum < maxSum) {
                start = mid + 1;
                result = mid;
            }
            else if (sum > maxSum) {
                end = mid - 1;
            }
            else {
                return (int) mid;
            }
        }
        return (int) result;
    }

    static long minSum(int n, int index, long target) {
//        k .. n = n + k . (n - k + 1) / 2
//        return (target + target - index) * (index + 1) / 2 + (target + target - (n - index - 1)) * (n - index) / 2 - target;

        int numLeftElement = index + 1;
        long outOfRangeLeft = 0;
        if (target - numLeftElement + 1 <= 0) {
            outOfRangeLeft =  -(target - numLeftElement + 1) + 1;
        }
        long sumLeft = 0;
        if (outOfRangeLeft > 0) {
            sumLeft = (target + 1) * target / 2 + outOfRangeLeft;
        }
        else {
            sumLeft = (target + target - numLeftElement + 1) * (numLeftElement) / 2;
        }

        int numRightElement = n - index;
        long outOfRangeRight = 0;
        if (target - numRightElement + 1 <= 0) {
            outOfRangeRight =  -(target - numRightElement + 1) + 1;
        }
        long sumRight = 0;
        if (outOfRangeRight > 0) {
            sumRight = (target + 1) * target / 2 + outOfRangeRight;
        }
        else {
            sumRight = (target + target - numRightElement + 1) * (numRightElement) / 2;
        }

        return sumLeft + sumRight - target;
    }
}
