class Solution {
    public int countOrders(int n) {
        int mod=(int)(1e9+7);
        if(n==1) return 1;
        long res=1;
        for(int i=2;i<=n;i++){
            long spaces=(i-1)*2 + 1;
            long poss=spaces*(spaces+1)/2;
            res=(res*poss)%mod;
        }
        return (int)res;
    }
}