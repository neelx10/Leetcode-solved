class Solution {
    public char findTheDifference(String s, String t) {
        int small=0,large=0;
        int i=0;
        for(;i<s.length();i++){
            small+=s.charAt(i);
            large+=t.charAt(i);
        }
        large+=t.charAt(i);
        return (char)(large-small);
    }
}