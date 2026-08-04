class Solution {
    public int search(int[] nums, int target) {
        int l, r, mid;
        l=0;
        r=nums.length-1;
        
        while(l<=r) {
            mid = (l+r)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target) {
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return -1;
    }
}
