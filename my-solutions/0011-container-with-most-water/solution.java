class Solution {
    public int maxArea(int[] height) {
            if (height == null || height.length == 0) return 0;
            int n = height.length;
            int left = 0;
            int right = n - 1;
            int area = 0;
            while (left < right) {
                int width = right - left;

                int curHeight = Math.min(height[left], height[right]);
                area = Math.max(curHeight * width, area);
                if (height[left] < height[right]) {
                    left++;
                }
                else {
                    right--;
                }
            }
            return area;
        }
}
