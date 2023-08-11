class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        prev[0]=1;
        for(int i=0;i<n;i++){
            for(int tar=0;tar<=amount;tar++){
                int notTake=prev[tar];
                int take=0;
                if(coins[i]<=tar) take=prev[tar-coins[i]];
                prev[tar]=take+notTake;
            }
        }
        return prev[amount];
    }
}







