class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cur0=0,cur1=0,ahead0=0,ahead1=0;
        for(int ind=prices.length-1;ind>=0;ind--){
            cur0=Math.max(ahead0,-prices[ind]+ahead1);
            cur1=Math.max(ahead1,(prices[ind]-fee)+ahead0);
            ahead0=cur0;
            ahead1=cur1;
        }
        return ahead0;
    }
}