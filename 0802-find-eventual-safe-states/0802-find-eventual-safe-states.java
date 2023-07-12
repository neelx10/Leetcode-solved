class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            int m=graph[i].length;
            for(int j=0;j<m;j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int u=q.poll();
            res.add(u);
            for(int v:adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }

        Collections.sort(res);
        return res;
    }
}