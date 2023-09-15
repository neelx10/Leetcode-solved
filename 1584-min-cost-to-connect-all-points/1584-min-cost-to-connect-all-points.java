class Solution {
    public int spanningTree(int V, int edges[][]){
	    // Code Here.
	    ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
	    int[] visited=new int[V];
        int sum=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[0]-y[0]);
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] it=pq.poll();
            int distance=it[0];
            int node=it[1];
            if(visited[node]==1) continue;
            visited[node]=1;
            sum+=distance;
            for(int[] temp:adj.get(node)) pq.offer(new int[]{temp[1],temp[0]});
        }
        return sum;
	}
    
    public int minCostConnectPoints(int[][] points) {
        int V=points.length;
        int[][] edges=new int[V*(V-1)/2][3];
        int k=0;
        for(int i=0;i<V;i++){
            for(int j=i+1;j<V;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges[k++]=new int[]{i,j,dist};
            }
        }
        return spanningTree(V,edges);
    }
}