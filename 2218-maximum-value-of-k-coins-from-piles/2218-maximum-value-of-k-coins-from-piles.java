class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] next=new int[k+1];
        int[] curr=new int[k+1];
        for(int i=piles.size()-1;i>=0;i--){
            for(int K=0;K<=k;K++){
                int notTake=next[K];
                int sum=0,take=(int)-1e9;
                for(int j=0;j<Math.min(K,piles.get(i).size());j++){
                    sum+=piles.get(i).get(j);
                    take=Math.max(take,sum+next[K-(j+1)]);
                }
                curr[K]=Math.max(take,notTake);
            }
            next=curr.clone();
        }
        return next[k];
    }
}