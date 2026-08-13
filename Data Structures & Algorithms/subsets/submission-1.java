class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if(index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        
        // choice 1
        // add the current index element to subset
        subset.add(nums[index]);
        dfs(nums, index+1, subset, res);

        // choice 2
        // backtrack
        // remove current index element from subset
        subset.remove(subset.size()-1);
        dfs(nums, index+1, subset, res);
    }
}
