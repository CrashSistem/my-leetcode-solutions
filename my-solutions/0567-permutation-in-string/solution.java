class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < len1; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        int l = 0;
        for (int r = len1 - 1; r < len2; r++) {
            if (matches(map1, map2)) return true;

            if (r + 1 < len2) {
                map2[s2.charAt(l) - 'a']--;
                l++;
                map2[s2.charAt(r + 1) - 'a']++;
            }
        }
        return false;
    }
    boolean matches(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
