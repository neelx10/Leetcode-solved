class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod=(int)(1e9+7);
        int[] prev=new int[target+1];
        int[] cur=new int[target+1];
        prev[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                cur[j]=0;
                for (int l = 1; l <= k; l++){
                    if(j-l>=0) cur[j]=(cur[j]+prev[j-l])%mod;
                    else break;
                }
            }
            prev=cur.clone();
        }
        return prev[target];
    }
}






