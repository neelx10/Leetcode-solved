class Solution {
    public boolean isPalindrome(int start,int end,String s){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
    
    public void solve(int idx,String s,List<List<String>> ans,List<String> list){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(idx,i,s)){
                list.add(s.substring(idx,i+1));
                solve(i+1,s,ans,list);
                list.remove(list.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        solve(0,s,ans,new ArrayList<String>());
        return ans;
    }
}