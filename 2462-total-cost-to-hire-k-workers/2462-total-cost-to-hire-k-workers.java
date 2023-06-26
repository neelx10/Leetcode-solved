class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        
        for (int i = 0; i < candidates; i++) pq1.offer(costs[i]);
        for (int i = Math.max(candidates, n - candidates); i < n; i++) pq2.offer(costs[i]);

        long ans = 0;
        int start = candidates;
        int end = n - 1 - candidates;

        while (k-- > 0) {
            if (pq2.isEmpty() || !pq1.isEmpty() && pq1.peek() <= pq2.peek()) {
                ans += pq1.poll();
                if (start <= end) pq1.offer(costs[start++]);
            } 
            else {
                ans += pq2.poll();
                if (start <= end) pq2.offer(costs[end--]);
            }
        }
        return ans;
    }
}





