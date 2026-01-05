class Solution {
    public int[] twoSum(int[] numbers, int target) {
            // using two pointers because numbers is sorted
            int n  = numbers.length;
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int sum = numbers[right] + numbers[left];
                if (sum == target) return new int[]{left + 1, right + 1};
                else  if (sum > target) right--;
                else left++;
            }
            return new int[] {-1, -1};
        }
}
