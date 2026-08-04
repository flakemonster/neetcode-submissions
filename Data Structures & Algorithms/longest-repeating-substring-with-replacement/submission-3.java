class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, res = 0, windowLen = 0, maxFreq = 0;
        int[] countMap = new int[26];
        while(l<s.length() && r<s.length()) {
            windowLen = r-l+1;
            // check if it's a valid window by this equatione
            // windowlen - maxFreq <= k
            // then res = max(res, windowLen)
            countMap[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, countMap[s.charAt(r)-'A']);
            if(windowLen - maxFreq <= k) {
                res = Math.max(res, windowLen);
                r++;
            } else {
                countMap[s.charAt(l)-'A']--;
                countMap[s.charAt(r)-'A']--;
                l++;
            }             
        }
        return res;
    }
}
