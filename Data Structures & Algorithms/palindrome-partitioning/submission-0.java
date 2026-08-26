class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), res);
        return res;
    }

    public void backtrack(String s, int index, List<String> subList, List<List<String>> res) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(subList));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                // added choice
                subList.add(substring);

                // backtrack
                backtrack(s, i+1, subList, res);

                // remove choice
                subList.remove(subList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;


        while(left<=right) {
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
