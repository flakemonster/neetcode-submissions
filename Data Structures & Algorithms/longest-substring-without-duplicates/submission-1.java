class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        char[] carr = s.toCharArray();
        int l = 0;
        int r = 0;
        int longest = 0;
        
        while(r<carr.length) {
            if(charSet.add(carr[r])) {
                longest = Math.max(longest, charSet.size());
                r++;
            } else {
                // found dup, 
                // remove chars from set and substring until dup is removed from beginning
                while(carr[l]!=carr[r]) {
                    charSet.remove(carr[l]);
                    l++;
                }
                charSet.remove(carr[l]);
                l++;
            }
        }
        return longest;
    }
}
