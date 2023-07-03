class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> arr=new ArrayList<Integer>();
        for(int num:cuts) arr.add(num);
        arr.add(cuts.length,n);
        arr.add(0,0);
        Collections.sort(arr);
        int[][] dp=new int[cuts.length+2][cuts.length+2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return min(0,arr.size()-1,arr,dp);
    }
    public int min(int i,int j,List<Integer> arr,int[][] dp){
        if(j-i<2) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini=(int)1e9;
        for(int ind=i+1;ind<=j-1;ind++){
            int cost=(arr.get(j)-arr.get(i))+min(i,ind,arr,dp)+min(ind,j,arr,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
}