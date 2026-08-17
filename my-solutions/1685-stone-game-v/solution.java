class Solution {

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];
        int[][] maxLeft = new int[n][n];
        int[][] maxRight = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxLeft[i][i] = stoneValue[i];
            maxRight[i][i] = stoneValue[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int totalSum = pref[j + 1] - pref[i];
                
                int k = i;
                while (
                    k < j && (pref[k + 1] - pref[i]) * 2 <= totalSum
                ) {
                    k++;
                }

                if (k - 1 >= i) {
                    int limit = k - 1;
                    if ((pref[k] - pref[i]) * 2 == totalSum) {
                        limit--;
                    }
                    if (limit >= i) {
                        dp[i][j] = Math.max(dp[i][j], maxLeft[i][limit]);
                    }
                }

                
                int start = k;
                if (
                    start <= j - 1 &&
                    (pref[start + 1] - pref[i]) * 2 == totalSum
                ) {
                    start++;
                }
                if (start <= j - 1) {
                    dp[i][j] = Math.max(dp[i][j], maxRight[start + 1][j]);
                }

                
                if (
                    k - 1 >= i &&
                    (pref[k] - pref[i]) * 2 == totalSum
                ) {
                    int mid = k - 1;
                    dp[i][j] = Math.max(dp[i][j], maxLeft[i][mid]);
                    dp[i][j] = Math.max(dp[i][j], maxRight[mid + 1][j]);
                }

                maxLeft[i][j] = Math.max(
                    maxLeft[i][j - 1],
                    totalSum + dp[i][j]
                );
                maxRight[i][j] = Math.max(
                    maxRight[i + 1][j],
                    totalSum + dp[i][j]
                );
            }
        }

        return dp[0][n - 1];
    }
}
