class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[] ahead=new int[2];
        int[] cur=new int[2];
        for(int ind=n-1;ind>=0;ind--){
            cur[0]=Math.max(ahead[0],-prices[ind]+ahead[1]);
            cur[1]=Math.max(ahead[1],(prices[ind]-fee)+ahead[0]);
            ahead=cur;
        }
        return ahead[0];
    }
}