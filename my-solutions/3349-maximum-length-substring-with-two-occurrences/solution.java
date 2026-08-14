class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];

        int left = 0;
        int maxLen = 0;
        char[] chars = s.toCharArray();

        for (int right = 0; right < chars.length; right++) {
            int ch = chars[right] - 'a';
            count[ch]++;

            while (count[ch] > 2) {
                count[chars[left] - 'a']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
