class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int min = Integer.MAX_VALUE;
        int l=0, r=nums.length-1;
        int mid;

        while(l<=r) {
            if(nums[l]<=nums[r]) {
                return Math.min(min, nums[l]);
            }
            mid = (l+r)/2;
            // compare with right half
            if(nums[mid]<nums[r]) {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return min;
    }
}
