class Solution {

    public boolean sumGame(String num) {
        int n = num.length();

        int sumLeft = 0;
        int sumRight = 0;
        int qLeft = 0;
        int qRight = 0;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            if (i < n / 2) {
                if (c == '?') qLeft++;
                else sumLeft += c - '0';
            } else {
                if (c == '?') qRight++;
                else sumRight += c - '0';
            }
        }

        if ((qLeft + qRight) % 2 != 0) {
            return true;
        }

        int sumDiff = sumLeft - sumRight;
        int qDiff = qLeft - qRight;

        return sumDiff * 2 != -qDiff * 9;
    }
}
