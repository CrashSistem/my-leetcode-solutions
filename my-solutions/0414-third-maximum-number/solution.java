class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> maxSet = new TreeSet<>();
        for (int num : nums) {
            maxSet.add(num);
        
            if (maxSet.size() > 3) {
                maxSet.pollFirst();
            }
        }
        return maxSet.size() < 3 ? maxSet.last() : maxSet.first();
    }
}
