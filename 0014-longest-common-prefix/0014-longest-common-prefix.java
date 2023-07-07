class Solution {
    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        String str = "";

        for (String s:strs) {
            int len = s.length();
            if (len < min) {
                min = len;
                str = s;
            }
        }

        for (int i = 0; i < min; i++) {
            for (String s:strs) {
                if (s.charAt(i) != str.charAt(i)) return str.substring(0,count);
            }
            count++;
        }
        return str.substring(0,count);
    }
}