class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, res = 0, windowLen = 0, maxFreq = 0;
        while(l<s.length() && r<s.length()) {
            windowLen = r-l+1;
            // check if it's a valid window by this equatione
            // windowlen - maxFreq <= k
            // then res = max(res, windowLen)
            maxFreq = countMaxFreq(s, l, r);
            if(windowLen - maxFreq <= k) {
                res = Math.max(res, windowLen);
                r++;
            } else {
                l++;
            }             
        }
        return res;
    }

    public int countMaxFreq(String s, int l, int r) {
        int maxF = 0;
        int[] countMap = new int[26];
        for(int i=l; i<=r;i++) {
            countMap[s.charAt(i) - 'A']++;
            maxF = Math.max(maxF, countMap[s.charAt(i) - 'A']);
        }
        return maxF;
    }
}
