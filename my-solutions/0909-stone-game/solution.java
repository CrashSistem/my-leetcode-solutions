class Solution {
    public boolean stoneGame(int[] piles) {
        // Alice can always win by choosing to take either all even-indexed 
        // or all odd-indexed piles. Since the total number of piles is even 
        // and the total sum of stones is odd, one of these subsets is strictly larger.
        return true;
    }
}
