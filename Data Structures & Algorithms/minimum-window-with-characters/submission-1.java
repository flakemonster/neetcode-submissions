class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        // HashMaps for t
        HashMap<Character, Integer> tCount = new HashMap<>();
        for(char c:t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int have, need;
        need = tCount.size();
        have = 0;
        int l=0, r=0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        System.out.println("have = "+have+" need = "+need);
        for(r=0; r<s.length();r++) {
            System.out.println("inside for");
            // iterating on right pointer
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0)+1);
            System.out.println(" putting "+c+" in window with value "+window.get(c));
            // we increment have if it's a value that's present in t
            if(tCount.containsKey(c) && window.get(c)==tCount.get(c)) {
                have+=1;
            }

            System.out.println("have = "+have+" need = "+need+" before while");
            // if have is same as need, shrink the window from left
            while(have==need) {
                System.out.println("have = "+have+" need = "+need);
                // compare with resLen, if size is smaller, update result
                if(r-l+1 < resLen) {
                    //Update res
                    res[0] = l;
                    res[1] = r;
                    resLen = r-l+1;
                }
                c = s.charAt(l);
                window.put(c, window.getOrDefault(c, 0)-1);
                if(tCount.containsKey(c) && window.get(c)<tCount.get(c)) {
                    have-=1;
                }
                l++;
            }
        }
        return (resLen != Integer.MAX_VALUE)?s.substring(res[0], res[1]+1):"";
    }
}
