class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String st: strs) {
            sb.append(st.length()+"#"+st);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0,length=0;
        char[] arr = str.toCharArray();
        System.out.println(str);
        while(i<arr.length) {
            StringBuilder sb = new StringBuilder();
            // increment i until finding #
            while(arr[i]!='#') {
                sb.append(arr[i]);
                i++;
            }

            // skipping '#'
            i++;
            int numOfChars = Integer.valueOf(sb.toString());
            int end = i+numOfChars;
            sb = new StringBuilder();
            int j = i;
            while(j<end) {
                sb.append(arr[j]);
                j++;
            }
            res.add(sb.toString());
            i=j;
        }
        return res;
    }
}
