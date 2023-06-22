class Solution {
    public void solve(List<String> ans,int n,int open,int close,String sb){
        if(sb.length()==n*2){
            ans.add(sb);
            return;
        }
        if(open<n) solve(ans,n,open+1,close,sb+"(");
        if(close<open) solve(ans,n,open,close+1,sb+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        solve(ans,n,0,0,"");
        return ans;
    }
}