class Solution {
    public String smallestPalindrome(String s) {

        int n = s.length();
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder(n / 2);
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;

            char ch = (char) ('a' + i);

            for (int j = 0; j < count[i] / 2; j++) {
                left.append(ch);
            }
            if (count[i] % 2 != 0) {
                mid = ch;
            }
        }
        StringBuilder result = new StringBuilder(left);
        if (mid != 0) {
            result.append(mid);
        }
        result.append(left.reverse());

        return result.toString();
    }

}
