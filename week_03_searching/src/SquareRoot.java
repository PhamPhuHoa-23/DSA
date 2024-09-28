public class SquareRoot {
    public static void main(String[] args) {
        int num = 2147395599;
        System.out.println("Sr(linear) of " + num + " is " + findSquareRoot(num));
        System.out.println("Sr(binary) of " + num + " is " + binarySearch(num));
    }

    static int findSquareRoot(int num) {
        int res = 1;
        while (true) {
            if (res * res == num) {
                return res;
            }
            else if (res * res < num) {
                res += 1;
            }
            else {
                return res - 1;
            }
        }
    }

    static int binarySearch(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = (end - start) / 2 + start;

            if ((long) mid * mid < (long) num) {
                start = mid + 1;
            }
            else if ((long) mid * mid > (long) num) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return Math.round(end);
    }
}
