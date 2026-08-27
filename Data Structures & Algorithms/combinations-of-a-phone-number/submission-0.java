class Solution {
    HashMap<Character, Set<Character>> m;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.equals(""))
            return res;
        m = new HashMap<>();
        m.put('2', Set.of('a', 'b', 'c'));
        m.put('3', Set.of('d', 'e', 'f'));
        m.put('4', Set.of('g', 'h', 'i'));
        m.put('5', Set.of('j', 'k', 'l'));
        m.put('6', Set.of('m', 'n', 'o'));
        m.put('7', Set.of('p', 'q', 'r', 's'));
        m.put('8', Set.of('t', 'u', 'v'));
        m.put('9', Set.of('w', 'x', 'y', 'z'));

        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    public void backtrack(String digits, int index, StringBuilder sb, List<String> res) {

        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        Character digit = digits.charAt(index);
        for(Character c: m.get(digit)) {
            // choice
            sb.append(c);
            // backtrack
            backtrack(digits, index+1, sb, res);
            // undo choice
            sb.deleteCharAt(index);
        }
    }
}
