//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++) adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        Queue<int[]> q=new LinkedList<>();
        int[] distance=new int[n];
        Arrays.fill(distance,(int)1e9);
        distance[src]=0;
        q.add(new int[]{0,src,0});
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int dis=temp[0];
            int node=temp[1];
            int stops=temp[2];
            if(stops>k) continue;
            for(int[] iter:adj.get(node)){
                int v=iter[0];
                int wt=iter[1];
                if(wt+dis<distance[v]){
                    distance[v]=wt+dis;
                    q.add(new int[]{distance[v],v,stops+1});
                }
            }
        }
        return (distance[dst]==1e9)?-1:distance[dst];
    }
}