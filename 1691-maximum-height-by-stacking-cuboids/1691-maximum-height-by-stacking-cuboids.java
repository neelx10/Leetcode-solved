class Solution {
    public int lengthOfLIS(int[][] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            dp[i]=nums[i][2];
            for(int prev=0;prev<i;prev++){
                if(nums[prev][0] >= nums[i][0] && nums[prev][1] >= nums[i][1] && nums[prev][2] >= nums[i][2]){
                    dp[i]=Math.max(dp[i],nums[i][2]+dp[prev]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
    
    public int maxHeight(int[][] cuboids) {
        for(int[] cuboid:cuboids) Arrays.sort(cuboid);
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return b[0] - a[0];
                if (a[1] != b[1]) return b[1] - a[1];
                return b[2] - a[2];
            }
        });
        return lengthOfLIS(cuboids);
    }
}




