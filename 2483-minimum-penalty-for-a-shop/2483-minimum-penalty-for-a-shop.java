class Solution {
    public int bestClosingTime(String s) {
        int n=s.length();
        int[] left_n=new int[n+1];
        int[] right_y=new int[n+1];
        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)=='N') left_n[i]=1+left_n[i-1];
            else left_n[i]=left_n[i-1];
        }
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='Y') right_y[i]=1+right_y[i+1];
            else right_y[i]=right_y[i+1];
        }
        
        int mini=(int)1e9;
        int miniPen=(int)1e9;
        for(int i=0;i<=n;i++){
            int currPen=left_n[i]+right_y[i];
            if(miniPen>currPen){
                miniPen=currPen;
                mini=i;
            }
        }
        return mini;
    }
}