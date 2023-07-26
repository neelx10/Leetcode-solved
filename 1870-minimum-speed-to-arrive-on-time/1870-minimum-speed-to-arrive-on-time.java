class Solution {
    private boolean solve(int[] dist, int speed,double hour) {
        double time = 0.0;
        for (int i = 0 ; i < dist.length; i++) {
            double t = (double) dist[i] / (double) speed;
            time += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        return time<=hour;
    }
    
    public int minSpeedOnTime(int[] dist, double hour) {
        int left=1;
        int right=(int)1e7;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(solve(dist,mid,hour)){
                ans=mid;
                right=mid-1;
            }
            else left=mid+1;
        }
        return (int)ans;
    }
}