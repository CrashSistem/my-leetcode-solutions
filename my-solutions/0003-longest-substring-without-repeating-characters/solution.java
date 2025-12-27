class Solution {
    public int lengthOfLongestSubstring(String s) {
            int answer = 0, left = 0, right = 0;
            Set<Character> set = new HashSet<>();
            while(right < s.length()) {
                if(!set.contains(s.charAt(right))) {
                    set.add(s.charAt(right));
                    answer =  Math.max(answer, right - left + 1);
                    right++;
                } else {
                    while(set.contains(s.charAt(right))) {
                        set.remove(s.charAt(left));
                        left++;
                    }
                }
            }
            return answer;
        }
}
