class Solution {
    public boolean checkValidString(String s) {
        int balance=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)==')') balance--;
            else balance++;
            if(balance<0) return false;
        }
        if(balance==0) return true;
        balance=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='(') balance--;
            else balance++;
            if(balance<0) return false;
        }
        return true;
    }
}