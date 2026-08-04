class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();
        while(i<=j) {
            System.out.println("loop start i = "+i+" j= "+j);
            if(!(Character.isLetter(c[i]) || Character.isDigit(c[i]))) {
                i++;
                continue;
            }

            if(!(Character.isLetter(c[j])|| Character.isDigit(c[j]))) {
                j--;
                continue;
            }
            if(Character.toLowerCase(c[i])!=Character.toLowerCase(c[j])) {
                //System.out.println("bad c["+i+"] = "+c[i]+" c["+j+"] = "+c[j]);
                return false;
            } else {
                //System.out.println("all good c["+i+"] = "+c[i]+" c["+j+"] = "+c[j]);
                i++;
                j--;
            }
        }
        //System.out.println("loop done");
        return true;
    }
}
