public class FirstBadVersion {
    public static boolean versions[] = {false, false, false, false, false, false, true, true };
    public static void main(String[] args) {
        System.out.println("First Bad Version is: " + findBadVersion(versions.length));
    }

    static boolean isBadVersion(int version) {
        return versions[version - 1];
    }

    static int findBadVersion(int n) {
        if (n == 1) {
            return 1;
        }

        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}
