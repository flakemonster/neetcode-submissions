class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s: strs) {
            char[] charAr = s.toCharArray();
            Arrays.sort(charAr);
            String sortedS = String.valueOf(charAr);
            m.putIfAbsent(sortedS, new ArrayList<String>());
            m.get(sortedS).add(s);
        }
        return new ArrayList<>(m.values());
    }
}
