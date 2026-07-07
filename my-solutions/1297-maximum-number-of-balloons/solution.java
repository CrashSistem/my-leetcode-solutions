class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];

        for (char c : text.toCharArray()){
            counts[c - 'a']++;
        }
        int minBalloons = counts['b' - 'a'];;
        minBalloons = Math.min(minBalloons, counts['a' - 'a']);
        minBalloons = Math.min(minBalloons, counts['l' - 'a'] / 2);
        minBalloons = Math.min(minBalloons, counts['o' - 'a'] / 2);
        minBalloons = Math.min(minBalloons, counts['n' - 'a']);
        return minBalloons;
    }
}
