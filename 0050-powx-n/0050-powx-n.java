class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        long N=(long)n;
        if(N<0){
            N=-1*N;
            x=1.0/x;
        }
        double ans=1;
        while(N>0){
            if((N&1) == 1) ans=ans*x;
            x=x*x;
            N>>=1;
        }
        return ans;
    }
}