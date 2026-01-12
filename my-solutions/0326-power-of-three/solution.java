class Solution {
    public boolean isPowerOfThree(int n) {
            double result = Math.log10(n) / Math.log10(3);
            return result % 1 == 0;
        }
}
