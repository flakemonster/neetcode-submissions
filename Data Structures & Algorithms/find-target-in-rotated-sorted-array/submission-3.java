class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1, m;

        while(l<=r) {
            m=(l+r)/2;
            if(nums[m]==target)
                return m;
            
            if(nums[l]<=nums[m]) {
                // l->m is sorted
                if(target<nums[m] && target>=nums[l]) {
                    // target between l ->m(excluded)
                    r=m-1;
                } else if(target<nums[m] && target<nums[l]) {
                    // target would be on right of m
                    l=m+1;
                } else {
                    // target greater than m
                    l=m+1;
                }
            } else {
                // l ->m isn't sorted
                // nums[l]>nums[m]
                if(target>nums[m] && target<=nums[r]) {
                    l=m+1;
                } else if(target>nums[m] && target>nums[r]) {
                    r=m-1;
                } else {
                    // target<nums[m]
                    r=m-1;
                }
            }
        } 
        return -1;
    }
}
