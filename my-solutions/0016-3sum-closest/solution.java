class Solution {
    public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int closest = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length; i++) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int curSum =  nums[i] + nums[left] + nums[right];

                    if (Math.abs(target - curSum) < Math.abs(target - closest)) closest = curSum;
                    if (curSum < target) left++;
                    else if (curSum > target) right--;
                    else return curSum ;
                }
            }
            return closest;
        }
}
