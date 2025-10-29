class Solution {
    public boolean isPalindrome(int x) {
        String strx = Integer.toString(x);

        String reverseStrX = new StringBuilder(strx).reverse().toString();

        return strx.equals(reverseStrX);
    }
}
