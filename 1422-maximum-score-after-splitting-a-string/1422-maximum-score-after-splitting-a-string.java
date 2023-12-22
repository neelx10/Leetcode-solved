class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int[] left=new int[n];
        int[] right=new int[n];
        //left
        if(s.charAt(0)=='0') left[0]=1;
        for(int i=1;i<n-1;i++){
            if(s.charAt(i)=='0') left[i]=1+left[i-1];
            else left[i]=left[i-1];
        }
        //right
        if(s.charAt(n-1)=='1') right[n-1]=1;
        for(int i=n-2;i>=1;i--){
            if(s.charAt(i)=='1') right[i]=1+right[i+1];
            else right[i]=right[i+1];
        }
        int maxi=0;
        int i=0,j=1;
        while(i<n-1) maxi=Math.max(maxi,left[i++]+right[j++]);
        return maxi;
    }
}