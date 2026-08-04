class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i,j,k;
        Set<List<Integer>> res = new HashSet<>();
        int target, sum;
        Arrays.sort(nums);
        for (int n: nums) {
            System.out.print(" "+n);
        }
        System.out.println("\n");
        for (i=0; i<=nums.length-3;i++) {
            // perform 2sum with target of -ve(nums[i])
            j = i+1;
            k = nums.length - 1;
            target = - nums[i];
            System.out.println("initial i = "+i+" j = "+j+" k = "+k+" target = "+target);
            while(j<k) {
                sum = nums[j] + nums[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    System.out.println("i = "+i+" j = "+j+" k = "+k);
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }
        List<List<Integer>> resList = new ArrayList<>(res);
        return resList;
    }
}
