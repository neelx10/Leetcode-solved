//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public void topSort(int u,int[] vis,Stack<Integer> st,ArrayList<ArrayList<int[]>> adj){
        vis[u]=1;
        for(int[] v:adj.get(u)){
            int node=v[0];
            if(vis[node]==0) topSort(node,vis,st,adj);
        }
        st.push(u);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
		for(int i=0;i<N;i++) adj.add(new ArrayList<int[]>());
		
		for(int i=0;i<M;i++) adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
		
		Stack<Integer> st=new Stack<>();
		int[] vis=new int[N];
		for(int i=0;i<N;i++){
		    if(vis[i]==0) topSort(i,vis,st,adj);
		}
		
		int[] distance=new int[N];
		Arrays.fill(distance,(int)1e9);
		distance[0]=0;
		
		while(!st.isEmpty()){
		    int u=st.pop();
		    for(int[] v:adj.get(u)){
		        int node=v[0];
		        int dist=v[1];
		        if(distance[u]+dist<distance[node]) distance[node]=distance[u]+dist;
		    }
		}
		for(int i=0;i<N;i++){
		    if(distance[i]==(int)1e9) distance[i]=-1;
		}
		return distance;
	}
}