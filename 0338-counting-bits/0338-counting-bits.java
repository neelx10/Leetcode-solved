class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        int[] BitsSetTable256 = new int[256];
        for (int i = 0; i < 256; i++) BitsSetTable256[i] = (i & 1) + BitsSetTable256[i / 2];
        for(int i=0;i<=n;i++){
            int temp=i;
            ans[i] = (BitsSetTable256[temp & 0xff] + BitsSetTable256[(temp >> 8) & 0xff] + BitsSetTable256[(temp >> 16) & 0xff]+ BitsSetTable256[temp >> 24]);
        }
        return ans;
    }
}