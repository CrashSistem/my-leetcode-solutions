class Solution {
    public String convert(String s, int numRows) {
            if (numRows == 1 || s.length() <= numRows) return s;

            StringBuilder[] sb = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                sb[i] = new StringBuilder();
            }

            int curRow = 0;
            boolean goingDown = false;

            for (char c : s.toCharArray()) {
                sb[curRow].append(c);

                if (curRow == numRows - 1 || curRow == 0) {
                    goingDown = !goingDown;
                }

                curRow += goingDown ? 1 : -1;
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder row : sb) {
                res.append(row);
            }
            return res.toString();
        }
}
