class Solution {
    public int findDuplicate(int[] nums) {
        int fast=0, slow=0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast!=slow);

        // now fast and slow are at same point
        // now move slow to head, move both ptrs 1 at a time

        slow = 0;

        while(fast!=slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
