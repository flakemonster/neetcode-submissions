class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<Integer>(), res);

        return res;
    }

    public void backtrack(int[] nums, int index, List<Integer> temp, List<List<Integer>> res) {
        // Base case: all elements have been processed for the current subset path
        if (index >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // Branch 1: Include the current number
        // We move to the immediate next index, allowing identical numbers to be included next
        temp.add(nums[index]);
        backtrack(nums, index + 1, temp, res);

        // Backtrack: remove the number to explore the "exclude" path
        temp.remove(temp.size() - 1);

        // Skip duplicates for the "exclude" branch
        // This ensures we don't start a new subset path with an identical number
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }

        // Branch 2: Exclude the current number (and all of its duplicates)
        // We jump straight to the next unique number
        backtrack(nums, nextIndex, temp, res);
    }
}
