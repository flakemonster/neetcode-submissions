class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();
        while(i<=j) {
            if(!(Character.isLetter(c[i]) || Character.isDigit(c[i]))) {
                i++;
                continue;
            }

            if(!(Character.isLetter(c[j])|| Character.isDigit(c[j]))) {
                j--;
                continue;
            }
            if(Character.toLowerCase(c[i])!=Character.toLowerCase(c[j])) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
