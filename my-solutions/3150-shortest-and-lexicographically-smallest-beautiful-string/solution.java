class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int count = 0;
        int left = 0;

        String ans = "";
        int minLen = n + 1;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                count++;
            }
            
            while (count == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }

                int currentLen = right - left + 1;
                String currentSub = s.substring(left, right + 1);

                if (
                    currentLen < minLen ||
                    (currentLen == minLen &&
                        currentSub.compareTo(ans) < 0)
                ) {
                    minLen = currentLen;
                    ans = currentSub;
                }

                count--;
                left++;
            }
        }

        return ans;
    }
}
