class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int min = Integer.MAX_VALUE;
        int l=0, r=nums.length-1;
        int mid;

        while(l<=r) {
            mid=(l+r)/2;
            if(nums[mid]>nums[l]) {
                //this part is sorted, minimum would be either left or after mid
                min = Math.min(nums[l], min);

                // now check the right of mid
                l=mid+1;
            } else if(nums[mid]<nums[l]) {
                //this part isn't sorted, so minimum has to be in this range l->mid
                min = Math.min(nums[mid], min);
                l=l+1;
                r=mid;
            } else {
                // l is same value as mid
                // what to do here?
                min = Math.min(nums[mid], min);
                l=l+1;
            }
        }
        return min;
    }
}
