class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) 
            return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        Arrays.fill(s1Count, 0);
        
        for(int i=0;i<s1.length(); i++) {
            s1Count[s1.charAt(i)-'a']++;
        }

        int l=0, r=s1.length()-1;
        while(r<s2.length()) {
            Arrays.fill(s2Count, 0);

            // first find the char count in s2
            for(int i=l; i<=r; i++) {
                s2Count[s2.charAt(i)-'a']++;
            }

            if(Arrays.equals(s1Count, s2Count))
                return true;
            r++;
            l++;
        }
        return false;
    }
}
