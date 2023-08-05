class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++) adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        Queue<int[]> q=new LinkedList<>();
        int[] distance=new int[n];
        Arrays.fill(distance,(int)1e9);
        distance[src]=0;
        q.add(new int[]{0,src,0});
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int dis=temp[0];
            int node=temp[1];
            int stops=temp[2];
            if(stops>k) continue;
            for(int[] iter:adj.get(node)){
                int v=iter[0];
                int wt=iter[1];
                if(wt+dis<distance[v]){
                    distance[v]=wt+dis;
                    q.add(new int[]{distance[v],v,stops+1});
                }
            }
        }
        return (distance[dst]==1e9)?-1:distance[dst];
    }
}