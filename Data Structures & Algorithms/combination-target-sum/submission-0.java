class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        dfs(nums, 0, target, 0, combination, res);
        return res;
    }

    public void dfs(int[] nums, int index, int target, int combinationSum, List<Integer> combination, List<List<Integer>> res) {
        if(combinationSum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if(index >= nums.length || combinationSum > target) {
            return;
        }

        // choice 1:
        // choose current number and add it to combination sum
        combination.add(nums[index]);
        dfs(nums, index, target, combinationSum+nums[index], combination, res);

        // choice 2:
        // don't choose current number, remove it from combination arraylist
        combination.remove(combination.size()-1);
        dfs(nums, index+1, target, combinationSum, combination, res);
    }
}
