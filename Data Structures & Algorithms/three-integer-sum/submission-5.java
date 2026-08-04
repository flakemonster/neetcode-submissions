class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i,j,k;
        Set<List<Integer>> res = new HashSet<>();
        int target, sum;
        Arrays.sort(nums);
        for (i=0; i<=nums.length-3;i++) {
            // perform 2sum with target of -ve(nums[i])
            j = i+1;
            k = nums.length - 1;
            target = - nums[i];
            while(j<k) {
                sum = nums[j] + nums[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }
        List<List<Integer>> resList = new ArrayList<>(res);
        return resList;
    }
}
