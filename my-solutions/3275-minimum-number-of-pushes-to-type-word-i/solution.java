class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int k = n / 8;
        int r = n % 8;

        return 4 * k * (k + 1) + r * (k + 1);
    }
}
