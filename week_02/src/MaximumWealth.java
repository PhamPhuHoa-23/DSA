public class MaximumWealth {
    public static int maximumWealth(int[][] accounts) {
        int richestWealth = 0;

        int m = accounts.length;
        int n = accounts[0].length;

        for (int i = 0, wealth = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                wealth += accounts[i][j];
            }

            if (wealth > richestWealth) {
                richestWealth = wealth;
            }
        }

        return richestWealth;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {2, 2, 1}};
        System.out.println(maximumWealth(accounts));
    }
}
