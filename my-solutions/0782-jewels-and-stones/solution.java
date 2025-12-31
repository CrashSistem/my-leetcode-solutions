class Solution {
    public int numJewelsInStones(String jewels, String stones) {
            // Time O(n) and O(n) space
            Set<Character> jewelSet = new HashSet<>();
            for (char c :  jewels.toCharArray()) {
                jewelSet.add(c);
            }

            int count = 0;

            for (int i  = 0; i < stones.length(); i++) { // O(n)
                char s =  stones.charAt(i);
                if (jewelSet.contains(s)) { // O(1)
                    count++;
                }
            }
            return count;
        }
}
