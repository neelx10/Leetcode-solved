class Pair{
    int first;
    long second;
    Pair(int first,long second){
        this.first=first;
        this.second=second;
    }

}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        long[] distance=new long[n];
        long[] ways=new long[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        Arrays.fill(ways,0);
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->Long.compare(x.second, y.second));
        distance[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            long dis=pq.peek().second;
            int node=pq.peek().first;
            pq.remove();
            for(Pair it:adj.get(node)){
                int v=it.first;
                long wt=it.second;
                if(wt+dis<distance[v]){
                    distance[v]=wt+dis;
                    pq.add(new Pair(v,wt+dis));
                    ways[v]=ways[node];
                }
                else if(wt+dis==distance[v]){
                    ways[v]=(ways[v]+ways[node])%1000000007;
                }
            }
        }
        return (int)ways[n-1];
    }
}