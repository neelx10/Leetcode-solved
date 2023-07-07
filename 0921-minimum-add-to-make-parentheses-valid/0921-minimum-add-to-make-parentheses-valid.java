class Solution {
    public int minAddToMakeValid(String s) {
        int ans=0;
        int count=0;
        for(char c:s.toCharArray()){
            if(c=='(') count++;
            else count--;
            if(count==-1){
                ans++;
                count++;
            }
        }
        return ans+count;
    }
}