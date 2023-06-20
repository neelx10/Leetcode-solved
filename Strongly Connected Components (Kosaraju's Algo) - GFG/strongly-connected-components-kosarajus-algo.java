//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(int node,Stack<Integer> stk,ArrayList<ArrayList<Integer>> adj,int[] visited){
        visited[node]=1;
        for(int it:adj.get(node)){
            if(visited[it]==0) dfs(it,stk,adj,visited);
        }
        stk.push(node);
    }
    public void dfs2(int[] visited,ArrayList<ArrayList<Integer>> adj,int node){
        visited[node]=1;
        for(int it:adj.get(node)){
            if(visited[it]==0) dfs2(visited,adj,it);
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st=new Stack<>();
        int[] visited=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0) dfs(i,st,adj,visited);
        }
        
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            visited[i]=0;
            reversedAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                reversedAdj.get(j).add(i);
            }
        }
        
        int count=0;
        while(!st.isEmpty()){
            int node=st.pop();
            if(visited[node]==0){
                count++;
                dfs2(visited,reversedAdj,node);
            }
        }
        return count;
    }
}



