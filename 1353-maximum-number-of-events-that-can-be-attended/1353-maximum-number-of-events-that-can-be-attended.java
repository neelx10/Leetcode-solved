class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, ans = 0;

        for (int d = 1; d <= 1e5; d++) {
            while (!pq.isEmpty() && pq.peek() < d) pq.poll();
            
            while (i < events.length && events[i][0] == d) pq.offer(events[i++][1]);
            
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }

            if (i >= events.length && pq.isEmpty()) break;
        }
        return ans;
    }
}