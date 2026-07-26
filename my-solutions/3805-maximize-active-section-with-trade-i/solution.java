class Solution {

    private static class Block {

        char type;
        int length;

        Block(char type, int length) {
            this.type = type;
            this.length = length;
        }
    }

    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        int n = s.length();
        List<Block> blocks = new ArrayList<>();
        int i = 0;

        while (i < n) {
            int start = i;
            char ch = s.charAt(i);
            while (i < n && ch == s.charAt(i)) {
                if (ch == '1') totalOnes++;
                i++;
            }
            blocks.add(new Block(ch, i - start));
        }

        if (blocks.size() < 3) return totalOnes;
        if (totalOnes == 0 || totalOnes == n) return totalOnes;

        int maxOnes = totalOnes;

        for (int j = 1; j < blocks.size() - 1; j++) {
            Block current = blocks.get(j);
            if (current.type == '1') {
                Block left = blocks.get(j - 1);
                Block right = blocks.get(j + 1);

                if (left.type == '0' && right.type == '0') {
                    maxOnes = Math.max(
                            maxOnes,
                            totalOnes + left.length + right.length
                    );
                }
            }
        }

        return maxOnes;
    }
}
