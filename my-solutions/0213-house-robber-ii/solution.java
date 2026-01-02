class Solution {
    public int rob(int[] nums) {
            if (nums == null) return 0;
            if (nums.length == 1) return nums[0];
            
            return Math.max(
                    simpleRob(nums, 0, nums.length - 2),
                    simpleRob(nums, 1, nums.length - 1)
            );
        }
        int simpleRob(int[] nums, int start, int end) {
            if (nums == null || nums.length == 0) return 0;
            
            int prev1 = 0;
            int prev2 = 0;
            
            for (int i = start; i <= end; i++) {
                int cur = Math.max(prev1, prev2 + nums[i]);
                prev2 = prev1;
                prev1 = cur;
            }
            return prev1;
        }
}
