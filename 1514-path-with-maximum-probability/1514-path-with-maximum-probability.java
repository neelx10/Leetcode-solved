class Pair{
    int node;
    double prob;
    Pair(int node,double prob){
        this.node=node;
        this.prob=prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int j=0;
        for(int[] edge:edges){
            int node=edge[0];
            int nb=edge[1];
            double prob=succProb[j++];
            adj.get(node).add(new Pair(nb,prob));
            adj.get(nb).add(new Pair(node,prob));
        }
        
        double[] prob=new double[n];
        prob[start]=1.0;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b) -> Double.compare(b.prob,a.prob));
        q.offer(new Pair(start,1.0));
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int u=temp.node;
            double upb=temp.prob;
            if(u==end) return upb;
            for(Pair it:adj.get(u)){
                int v=it.node;
                double vpb=it.prob;
                if(upb*vpb>prob[v]){
                    prob[v]=upb*vpb;
                    q.offer(new Pair(v,prob[v]));
                }
            }
        }
        return 0.0;
    }
}