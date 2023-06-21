class Solution {
    public void dfs(int node,int parent,int[] visited,List<List<Integer>> adj,int[] timein,int[] low,List<List<Integer>> bridges,int counter){
        //tarjan's algorithm
        visited[node]=1;
        timein[node]=low[node]=counter;
        counter++;
        for(int it:adj.get(node)){
            if(it==parent) continue;
            if(visited[it]==0){
                dfs(it,node,visited,adj,timein,low,bridges,counter);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>timein[node]) bridges.add(Arrays.asList(it,node));
            }
            else low[node]=Math.min(low[node],low[it]);
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(List<Integer> edge:connections){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        int[] visited=new int[n];
        int[] timein=new int[n];
        int[] low=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,visited,adj,timein,low,bridges,1);
        return bridges;
    }
}