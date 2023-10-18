class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int dfs(int node, int[] time) {
        if (memo.containsKey(node)) return memo.get(node);
        if (graph.get(node).size() == 0) return time[node];
        int ans = 0;
        for (int neighbor: graph.get(node)) ans = Math.max(ans, dfs(neighbor, time));
        memo.put(node, time[node] + ans);
        return time[node] + ans;
    }
    
    public int minimumTime(int n, int[][] relations, int[] time) {
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge: relations) graph.get(edge[0] - 1).add(edge[1] - 1);
        int ans = 0;
        for (int node = 0; node < n; node++) ans = Math.max(ans, dfs(node, time));
        return ans;
    }
}