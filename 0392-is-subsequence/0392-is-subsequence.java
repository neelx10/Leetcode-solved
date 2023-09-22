class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0;
        int n = t.length() , m = s.length(); 
        if(m == 0) return true;
        while(i < n){
            if(t.charAt(i) == s.charAt(j)) j++;
            i++;
            if(j==m) return true;
        }
        return false;
    }
}