class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) 
            return findMedianSortedArrays(nums2, nums1);
        
        int l=0, r=nums1.length;
        int m, Aleft, Aright, Bleft, Bright;
        // A is nums1
        // B is nums2

        int total = nums1.length+nums2.length;
        int half = (total+1)/2; // added 1 so that the left half always contains 1 more than right half

        while(l<=r) {
            m = (l+r)/2;
            int partition1Elements= m; 
            int partition2Elements= half-m;
            Aleft=(partition1Elements-1)>=0?nums1[partition1Elements-1]:Integer.MIN_VALUE;
            Aright=(partition1Elements)<nums1.length?nums1[partition1Elements]:Integer.MAX_VALUE;
            Bleft=(partition2Elements-1)>=0?nums2[partition2Elements-1]:Integer.MIN_VALUE;
            Bright=(partition2Elements)<nums2.length?nums2[partition2Elements]:Integer.MAX_VALUE;

            if(Aleft<=Bright && Bleft<=Aright) {
                // found our partition
                if(total%2==0) 
                    return (double)(Math.max(Aleft, Bleft)+Math.min(Aright, Bright))/(double)2;
                else 
                    return Math.max(Aleft, Bleft);
            } else if (Aleft>Bright) {
                // in this case, the partition for A is too much on right, move left
                r=m-1;
            } else {
                // Bleft>Aright
                // in this case, the partition for A is too much on left, move right
                l=m+1;
            }
        }
        return 0;
    }
}
