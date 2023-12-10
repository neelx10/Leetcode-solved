class Solution {
    public int maxProfit(int[] prices) {
        int[] next=new int[5];
        int[] cur=new int[5];
        for(int i=prices.length-1;i>=0;i--){
            for(int flag=3;flag>=0;flag--){
                if(flag%2==0) cur[flag]=Math.max(next[flag],-prices[i]+next[flag+1]);
                else cur[flag]=Math.max(next[flag],prices[i]+next[flag+1]);
            }
            next=cur;
        }
        return next[0];
    }
}