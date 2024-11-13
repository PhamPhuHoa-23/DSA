public class HIndexII {
    // https://leetcode.com/problems/h-index-ii/description/?envType=problem-list-v2&envId=binary-search&difficulty=EASY%2CMEDIUM

    public static void main(String[] args) {
        System.out.println(hIndex(new int[] {0,1,3,5,6}));
        System.out.println(hIndex(new int[] {1,2,100}));
    }

    static int hIndex(int[] citations) {
        int n = citations.length;
        int s = 0;
        int e = n - 1;
        int a = 0;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (citations[m] >= n - m) {
                a = n - m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return a;
    }
}
