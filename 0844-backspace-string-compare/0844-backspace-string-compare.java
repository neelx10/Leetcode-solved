class Solution {
    public String solve(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#') ans.push(c);
            else if (!ans.empty()) ans.pop();
        }
        return String.valueOf(ans);
    }
    
    public boolean backspaceCompare(String S, String T) {
        return solve(S).equals(solve(T));
    }
}