class Solution {
    public int smallestNumber(int n, int t) {
        int x = n;

        while (true) {
            if (getProduct(x) % t == 0) return x;
            x++;
        }
    }

    long getProduct(int n) {
        long product = 1;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0)
                return 0;
            product *= digit;
            n /= 10;
        }
        return product;
    }
}
