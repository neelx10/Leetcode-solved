//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

//User function Template for Java

class Solution{
    static void dfs(int row,int col,int[][] visited,char[][] board,int[] roww,int[] coll){
        visited[row][col]=1;
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+roww[i];
            int ncol=col+coll[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,visited,board,roww,coll);
            }
        }
    }
    
    static char[][] fill(int n, int m, char board[][])
    {
        int[] roww={-1,0,1,0};
        int[] coll={0,-1,0,1};
        int[][] visited = new int[n][m];
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && visited[0][j]==0) dfs(0,j,visited,board,roww,coll);
            if(board[n-1][j]=='O' && visited[n-1][j]==0) dfs(n-1,j,visited,board,roww,coll);
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && visited[i][0]==0) dfs(i,0,visited,board,roww,coll);
            if(board[i][m-1]=='O' && visited[i][m-1]==0) dfs(i,m-1,visited,board,roww,coll);
        }
        for(int k=1;k<n-1;k++){
            for(int l=1;l<m-1;l++){
                if(board[k][l]=='O' && visited[k][l]==0) board[k][l]='X';
            }
        }
        return board;
    }
}