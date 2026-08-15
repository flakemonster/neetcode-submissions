class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combinationList = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, combinationList, res);
        return res;
    }

    public void dfs(int[] candidates, int index, int total, int target,
        List<Integer> combinationList, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(combinationList));
            return;
        }
        if (index >= candidates.length || total > target) {
            return;
        }

        // choice 1: choose the current number
        combinationList.add(candidates[index]);
        dfs(candidates, index + 1, total + candidates[index], target, combinationList, res);

        // choice 2: backtrack, and don't choose number, move next index
        combinationList.remove(combinationList.size() - 1);

        int nextIndex = index + 1;
        while((index+1)<candidates.length && candidates[index]== candidates[index+1]) {
            index++;
        }
            
        dfs(candidates, index+1, total, target, combinationList, res);
    }
}
