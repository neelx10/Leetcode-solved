class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] intervals=new int[n+1];
        for(int i=0;i<n+1;i++){
            int start=Math.max(0,i-ranges[i]);
            int end=Math.min(n,i+ranges[i]);
            intervals[start]=Math.max(intervals[start],end);
        }
        
        int taps=0;
        int curr=0,next=0;
        for(int i=0;i<=n;i++){
            if(i>next) return -1;
            if(i>curr){
                taps++;
                curr=next;
            }
            next=Math.max(next,intervals[i]);
        }
        return taps;
    }
}