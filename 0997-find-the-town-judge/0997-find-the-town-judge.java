class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusty=new int[n+1];
        for(int[] r:trust){
            trusty[r[0]]--;
            trusty[r[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(trusty[i]==n-1) return i;
        }
        return -1;
    }
}