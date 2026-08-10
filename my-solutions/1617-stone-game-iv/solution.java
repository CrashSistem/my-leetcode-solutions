class Solution {

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            if (!dp[i]) {
                for (int k = 1; i + k * k <= n; k++) {
                    dp[i + k * k] = true;
                }

                if (dp[n]) {
                    return true;
                }
            }
        }

        return dp[n];
    }
}
