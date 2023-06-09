class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int temp=money;
        int count=0;
        for(int i:prices){
            temp-=i;    
            count++;
            if(temp<0) return money;
            if(count==2) return temp;
        }
        return temp;
    }
}