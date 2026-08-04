class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0)+1);
            //System.out.println("char "+ s.charAt(i)+" val "+h.get(s.charAt(i)));
        }
        for (int i=0; i<t.length(); i++) {
            h.put(t.charAt(i), h.getOrDefault(t.charAt(i), 0)-1);
            //System.out.println("char "+ t.charAt(i)+" val "+h.get(t.charAt(i)));
        }

        for (char c: h.keySet()) {
            //System.out.println("c "+ c+" value "+ h.get(c));
            if (h.get(c) != 0) {
                return false;
            }
        }
        return true; 
    }
}
