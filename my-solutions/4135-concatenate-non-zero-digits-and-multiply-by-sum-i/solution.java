class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0;

        long x = 0;
        long sum = 0;
        int i = 1;
        
        while (n != 0){
            int digit = n % 10;
            sum += digit;
            n /= 10;
            if (digit == 0) continue;
            x += i * digit;
            i *= 10;
        }

        return x * sum;
    }
}
