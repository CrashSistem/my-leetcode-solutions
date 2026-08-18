class Solution {
    public static int largestInteger(int[] nums, int k) {
    int n = nums.length;
    if (n == 0) return -1;

    if (n == k) {
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    if (k == 1) {
        int[] freq = new int[51];
        for (int c : nums) {
            freq[c]++;
        }
        int max = -1;
        for (int c : nums) {
            if (freq[c] == 1) {
                max = Math.max(max, c);
            }
        }
        return max;
    }

    if (nums[0] == nums[n - 1]) return -1;

    boolean countFirst = true;
    boolean countLast = true;

    for (int i = 1; i < n - 1; i++) {
        if (nums[i] == nums[0]) countFirst = false;
        if (nums[i] == nums[n - 1]) countLast = false;

        if (!countFirst && !countLast) break;
    }

    int max = -1;

    if (countFirst) max = Math.max(max, nums[0]);
    if (countLast) max = Math.max(max, nums[n - 1]);

    return max;
}
}
