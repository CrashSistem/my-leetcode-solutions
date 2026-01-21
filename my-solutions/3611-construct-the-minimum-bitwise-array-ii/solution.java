class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
            int n = nums.size();
            int[] ans = new int[n];

            for (int i = 0; i < n; i++) {
                int val = nums.get(i);

                if (val == 2) {
                    ans[i] = -1;
                    continue;
                }
                else {
                    int t = ~val;
                    int firstZeroBit = t & -t;

                    ans[i] = val ^ (firstZeroBit >> 1);
                }
            }
            return ans;
        }
}
