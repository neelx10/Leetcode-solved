class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            int temp=i;
            while (temp > 0) {
                ans[i] += temp & 1;
                temp >>= 1;
            }
        }
        return ans;
    }
}