class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int[] dp = new int[4];

        for (int i = n - 1; i >= 0; i--) {
            int maxScore = Integer.MIN_VALUE;
            int currentSum = 0;

            for (int k = 1; k <= 3 && i + k <= n; k++) {
                currentSum += stoneValue[i + k - 1];

                int nextDp = dp[(i + k) % 4];
                maxScore = Math.max(maxScore, currentSum - nextDp);
            }
            dp[i % 4] = maxScore;
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}
