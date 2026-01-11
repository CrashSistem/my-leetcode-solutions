class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            backtrack(result, new ArrayList<>(), nums, visited);
            return result;
        }
        void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, boolean[] visited) {
            if (tempList.size() == nums.length) {
                result.add(new ArrayList<>(tempList));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;

                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

                visited[i] = true;
                tempList.add(nums[i]);

                backtrack(result, tempList, nums, visited);

                visited[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
}
