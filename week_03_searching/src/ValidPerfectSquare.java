public class ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 16;

        System.out.println(num + " is " + isPerfectSquare(num));
    }

    static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid * mid == num) {
                return true;
            }
            else if (mid * mid < num) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}

