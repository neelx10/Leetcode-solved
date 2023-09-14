class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans =new LinkedList<>(); 
        HashMap<String,PriorityQueue<String>> adj=new HashMap<>();
        for(List<String> ticket:tickets){
            adj.putIfAbsent(ticket.get(0),new PriorityQueue<String>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK",adj,ans);
        return ans;
    }
    public void dfs(String src,HashMap<String,PriorityQueue<String>> adj,LinkedList<String> ans){
        PriorityQueue<String> temp=adj.get(src);
        while(temp!=null && temp.size()>0) dfs(temp.poll(),adj,ans);
        ans.addFirst(src);
    }
}