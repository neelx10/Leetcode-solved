class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int elem: hand) pq.add(elem);
        while(!pq.isEmpty()){
            int top = pq.poll();
            for(int i=1; i<W; i++){
                if(!pq.remove(top+i)) return false;
            }
        }
        return true;
    }
}