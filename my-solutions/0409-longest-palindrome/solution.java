class Solution {
    public int longestPalindrome(String s) {
            int[] count = new int[128];
            for (char c : s.toCharArray()) {
                count[c]++;
            }
            int len = 0;
            boolean hasOdd = false;

            for (int c : count) {
                len += (c / 2) * 2;
                if (c % 2 == 1) {
                    hasOdd = true;
                }
            }
            return hasOdd ? len + 1 : len;
        }
}
