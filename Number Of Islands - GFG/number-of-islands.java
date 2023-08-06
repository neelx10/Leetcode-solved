//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v){
            return; 
        }
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
    }
}

class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        DisjointSet ds=new DisjointSet(rows*cols);
        int[][] visited=new int[rows][cols];
        int count=0;
        List<Integer> ans=new ArrayList<>();
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int i=0;i<operators.length;i++){
            int row=operators[i][0];
            int col=operators[i][1];
            if(visited[row][col]==0){
                visited[row][col]=1;
                count++;
                for(int j=0;j<4;j++){
                    int adjr=row+dr[j];
                    int adjc=col+dc[j];
                    if(adjr>=0 && adjr<rows && adjc>=0 && adjc<cols && visited[adjr][adjc]==1){
                        int nodeNo=row*cols+col;
                        int adjNodeNo=adjr*cols+adjc;
                        if(ds.findUPar(nodeNo)!=ds.findUPar(adjNodeNo)){
                            count--;
                            ds.unionByRank(nodeNo,adjNodeNo);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
    
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends