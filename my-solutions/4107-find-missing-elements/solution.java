class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        boolean[] present = new boolean[max - min + 1];
        for (int num : nums) {
            present[num - min] = true;
        }


        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                result.add(min + i);
            }
        }
        return result;
    }
}
