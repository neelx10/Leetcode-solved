class Solution {
    public boolean dfs(int[] vis,int[] pathVis,ArrayList<ArrayList<Integer>> adj,int node){
        vis[node]=1;
        pathVis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(vis,pathVis,adj,it)) return true;
            }
            else if(pathVis[it]==1) return true;
        }
        pathVis[node]=0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] edges) {
        int N=numCourses;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++) adj.add(new ArrayList<>());
        
        for(int[] edge:edges) adj.get(edge[0]).add(edge[1]);
        
        int[] vis=new int[N];
        int[] pathVis=new int[N];
        
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                if(dfs(vis,pathVis,adj,i)) return false;
            }
        }
        return true;
    }
}
