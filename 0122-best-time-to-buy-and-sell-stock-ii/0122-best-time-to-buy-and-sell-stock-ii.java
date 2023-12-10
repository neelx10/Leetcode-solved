class Solution {
    public int maxProfit(int[] prices) {
        int next1=0,next2=0,cur1=0,cur2=0;
        for(int i=prices.length-1;i>=0;i--){
            cur1=Math.max(next1,-prices[i]+next2);
            cur2=Math.max(next2,prices[i]+next1);
            next1=cur1;
            next2=cur2;
        }
        return next1;
    }
}