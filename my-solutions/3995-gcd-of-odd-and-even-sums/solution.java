class Solution {
    public int gcdOfOddEvenSums(int n) {
        /*
        The answer is simply **n**.

        1. The sum of the first n odd numbers is sumOdd = n^2`.
        2. The sum of the first n even numbers is `sumEven = n * (n + 1)`.

        So, we need to find:
        gcd(n^2, n * (n + 1)) = n * gcd(n, n + 1)

        Since any two consecutive integers n and (n + 1) are coprime, gcd(n, n + 1) = 1.
        Therefore, gcd = n * 1 = n.
        */
        return n;
    }
}
