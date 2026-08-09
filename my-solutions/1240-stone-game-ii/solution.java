class Solution{
    public int stoneGameII(int[] piles) {
        int n = piles.length; 
        int[] suffixSum = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        // dp[i][M] — max. stones that the player will pick up from position i at the current M
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                if (i + 2 * M >= n) {
                    dp[i][M] = suffixSum[i];
                    continue;
                }

                int minOpponent = Integer.MAX_VALUE;
                for (int X = 1; X <= 2 * M; X++) {
                    int nextM = Math.max(M, X);
                    minOpponent = Math.min(minOpponent, dp[i + X][nextM]);
                }
                dp[i][M] = suffixSum[i] - minOpponent;
            }
        }

        return dp[0][1];
    }
}
