//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] board) {

        // Your code here
        int count=0;
        int m=board.length;
        int n=board[0].length;
        int[] roww={-1,0,1,0};
        int[] coll={0,-1,0,1};
        int[][] visited = new int[m][n];
        //first and last col
        for(int i=0;i<m;i++){
            if(board[i][0]==1 && visited[i][0]==0){
                dfs(i,0,visited,board,roww,coll);
            }
            if(board[i][n-1]==1 && visited[i][n-1]==0){
                dfs(i,n-1,visited,board,roww,coll);
            }
        }
        //first and last row
        for(int j=0;j<n;j++){
            if(board[0][j]==1 && visited[0][j]==0){
                dfs(0,j,visited,board,roww,coll);
            }
            if(board[m-1][j]==1 && visited[m-1][j]==0){
                dfs(m-1,j,visited,board,roww,coll);
            }
        }
        for(int k=1;k<m-1;k++){
            for(int l=1;l<n-1;l++){
                if(board[k][l]==1 && visited[k][l]==0){
                    count++;
                }
            }
        }
        return count;
    }

    
    void dfs(int row,int col,int[][] visited,int[][] board,int[] roww,int[] coll){
        visited[row][col]=1;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+roww[i];
            int ncol=col+coll[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]==0 && board[nrow][ncol]==1){
                dfs(nrow,ncol,visited,board,roww,coll);
            }
        }
    }
}