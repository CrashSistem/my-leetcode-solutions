class Solution {

    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[] right = new int[m + 1];
        right[m] = n;

        int ptr = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            while (ptr >= 0 && word1.charAt(ptr) != word2.charAt(i)) {
                ptr--;
            }
            right[i] = ptr;
            if (ptr >= 0) ptr--;
        }

        int[] ans = new int[m];
        boolean mismatchUsed = false;
        int p1 = 0;

        for (int i = 0; i < m; i++) {
            while (p1 < n) {
                if (word1.charAt(p1) == word2.charAt(i)) {
                    ans[i] = p1;
                    p1++;
                    break;
                } else if (!mismatchUsed && right[i + 1] > p1) {
                    mismatchUsed = true;
                    ans[i] = p1;
                    p1++;
                    break;
                }
                p1++;
            }
            if (i > 0 && ans[i] <= ans[i - 1] && p1 >= n) {
                return new int[0];
            }
        }


        int diff = 0;
        for (int i = 0; i < m; i++) {
            if (i > 0 && ans[i] <= ans[i - 1]) return new int[0];
            if (word1.charAt(ans[i]) != word2.charAt(i)) diff++;
        }

        return diff <= 1 ? ans : new int[0];
    }
}
