class Solution {
    public void solve(List<String> ans,int n,int open,int close,StringBuilder sb){
        if(sb.length()==n*2){
            ans.add(sb.toString());
            return;
        }
        if(open<n){
            solve(ans,n,open+1,close,sb.append('('));
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            solve(ans,n,open,close+1,sb.append(')'));
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        solve(ans,n,0,0,new StringBuilder());
        return ans;
    }
}