class Solution {

    public int maxActiveSectionsAfterTrade(String s) {

        // T: O(n)
        // S: O(1)

        int totalOnes = 0;
        int leftZeros = 0;
        int curZeros = 0;
        int maxGain = 0;
        boolean hasBetween = false;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                totalOnes++;

                if (curZeros > 0) {
                    leftZeros = curZeros;
                    curZeros = 0;
                }
                hasBetween = true;
            } else { // '0'
                curZeros++;
                if (hasBetween && leftZeros > 0) {
                    maxGain = Math.max(maxGain, leftZeros + curZeros);
                }
            }
        }
        return totalOnes + maxGain;
    }
}
