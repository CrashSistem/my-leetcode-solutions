impl Solution {
    pub fn min_pair_sum(nums: Vec<i32>) -> i32 {
  let mut nums = nums;
  nums.sort();

  let mut left = 0;
  let mut right = nums.len() - 1;
  let mut max = 0;
  while left < right{
    let cur_sum = nums[left] + nums[right];
    max = i32::max(max, cur_sum);
    
    left += 1;
    right -= 1;
  }

  return max;
}  

}
