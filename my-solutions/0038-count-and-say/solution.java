class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "0";

        String current = "1";

        for (int i = 2; i <=n; i++) {
            current = buildNext(current);
        }
        
        return current;
    }

    String buildNext(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i + 1 < n && str.charAt(i) == str.charAt(i + 1))
                count++;
            else {
                sb.append(count).append(str.charAt(i));
                count = 1;
            }
        }
        return sb.toString();
    }
}
