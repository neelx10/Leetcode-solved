class DisjointSet{
    static int[] parent;
    static int[] rank;
    DisjointSet(int V){
        parent=new int[V+1];
        rank=new int[V+1];
        for(int i=0;i<=V;i++) parent[i]=i;
    }
    static int findParent(int node){
        if(node==parent[node]) return node;
        return parent[node]=findParent(parent[node]);
    }
    static void unionByRank(int u,int v){
        int u_parent=findParent(u);
        int v_parent=findParent(v);
        if(rank[u_parent]>rank[v_parent]) parent[v_parent]=u_parent;
        else if(rank[u_parent]<rank[v_parent]) parent[u_parent]=v_parent;
        else{
            parent[v_parent]=u_parent;
            rank[u_parent]++;
        }
    }
}

class Solution {
    public int spanningTree(int V, int edges[][]){
	    // Code Here.
	    DisjointSet set=new DisjointSet(V);
	    int sum=0;
	    for(int[] edge:edges){
	        if(set.findParent(edge[0])!=set.findParent(edge[1])){
	            sum+=edge[2];
	            set.unionByRank(edge[0],edge[1]);
	        }
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
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        return spanningTree(V,edges);
    }
}