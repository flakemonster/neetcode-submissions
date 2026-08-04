class Solution {
    public int search(int[] nums, int target) {
        int l, r, mid;
        l=0;
        r=nums.length-1;
        
        while(l<=r) {
            mid = (l+r)/2;
            System.out.println("l "+l+" r "+r+" mid "+mid+" target "+target);
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target) {
                r=mid-1;
                System.out.println("shifting r "+r);
            } else {
                l=mid+1;
                System.out.println("shifting l "+l);
            }
        }
        return -1;
    }
}
