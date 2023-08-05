class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] edge:times){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        
        int[] distance=new int[n+1];
        Arrays.fill(distance,(int)1e9);
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});
        
        distance[k]=0;
        while(!pq.isEmpty()){
            int len=pq.size();
            while(len-- > 0){
                int[] temp=pq.poll();
                int u=temp[0];
                int dist=temp[1];
                for(int[] it:adj.get(u)){
                    int v=it[0];
                    int wt=it[1];
                    if(wt+dist<distance[v]){
                        distance[v]=wt+dist;
                        pq.offer(new int[]{v,distance[v]});
                    }
                }
            }
        }
        
        int maxTime = 0;
        for (int i = 1; i < n + 1; i++) {
            maxTime = Math.max(maxTime, distance[i]);
        }
        return maxTime == (int) 1e9 ? -1 : maxTime;
    }
}