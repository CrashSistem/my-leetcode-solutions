class Solution {
    public boolean isPalindrome(String s) {
            String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            StringBuilder reversed = new StringBuilder(cleaned).reverse();
            return reversed.toString().equals(cleaned);

        }
}
