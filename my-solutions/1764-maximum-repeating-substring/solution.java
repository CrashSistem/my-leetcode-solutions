class Solution {
    public int maxRepeating(String sequence, String word) {
            int k = 0;
            StringBuilder repeat = new StringBuilder(word);

            while (sequence.contains(repeat)) {
                k++;
                repeat.append(word);
            }
            return k;
        }
}
