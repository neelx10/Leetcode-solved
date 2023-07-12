//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

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
    
    public boolean isPossible(int N,int P, int[][] edges)
    {
        // Your Code goes here
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