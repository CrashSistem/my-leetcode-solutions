class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        if (s == null || queries == null || queries.length == 0) {
            return new int[0];
        }

        int m = s.length();
        int n = queries.length;
        long MOD = 1_000_000_007L;

        long[] power10 = new long[m + 1];
        power10[0] = 1;
        for (int i = 1; i <= m; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }

        int[] prefixSum = new int[m + 1];
        long[] prefixX = new long[m + 1];
        int[] countNonZero = new int[m + 1];

        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            
            prefixSum[i + 1] = prefixSum[i];
            prefixX[i + 1] = prefixX[i];
            countNonZero[i + 1] = countNonZero[i];

            if (digit != 0) {
                prefixSum[i + 1] += digit;
                prefixX[i + 1] = (prefixX[i] * 10 + digit) % MOD;
                countNonZero[i + 1]++;
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            long sum = prefixSum[right + 1] - prefixSum[left];

            if (sum == 0) {
                answer[i] = 0;
                continue;
            }

            int k = countNonZero[right + 1] - countNonZero[left];
            long x = prefixX[right + 1] - (prefixX[left] * power10[k]) % MOD;
            
            if (x < 0) {
                x += MOD;
            }

            long result = (x * (sum % MOD)) % MOD;
            answer[i] = (int) result;
        }

        return answer;
    }
}
