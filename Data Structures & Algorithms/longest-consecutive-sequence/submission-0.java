class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            s.add(nums[i]);
        }

        int longest=0, length=0;

        for(int i=0; i<nums.length; i++) {
            length = 0;
            int n = nums[i];
            if(!s.contains(n-1)) {
                // it's a start of sequence
                while(s.contains(n)) {
                    length++;
                    n++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
