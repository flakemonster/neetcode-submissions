class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), nums);

        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        // base case

        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // do backtracking on loop

        for(int i=0; i<nums.length; i++) {
            if(temp.contains(nums[i])) {
                continue;
            }

            // add the number
            temp.add(nums[i]);

            // backtrack the method
            backtrack(res, temp, nums);

            // remove the number
            temp.remove(temp.size()-1);
        }
    }
}
