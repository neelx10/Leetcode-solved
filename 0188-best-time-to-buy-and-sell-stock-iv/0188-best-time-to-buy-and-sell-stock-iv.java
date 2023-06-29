class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[] ahead=new int[2*k+1];
        int[] cur=new int[2*k+1];
        for(int ind=n-1;ind>=0;ind--){
            for(int cap=2*k - 1;cap>=0;cap--){
                if(cap%2==0) cur[cap]=Math.max(ahead[cap],-prices[ind]+ahead[cap+1]);
                else cur[cap]=Math.max(ahead[cap],prices[ind]+ahead[cap+1]);
            }
            ahead=cur;
        }
        return ahead[0];
    }
}