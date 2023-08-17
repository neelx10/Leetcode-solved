class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] visited=new int[m][n];
        int[][] ans=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    visited[i][j]=1;
                    ans[i][j]=0;
                    q.offer(new int[]{i,j,0});
                }
            }
        }

        while(!q.isEmpty()){
            int[] temp=q.poll();
            int r=temp[0];
            int c=temp[1];
            int s=temp[2];
            int[] delrow={-1,0,1,0};
            int[] delcol={0,-1,0,1};
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && mat[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    visited[nrow][ncol]=1;
                    ans[nrow][ncol]=s+1;
                    q.offer(new int[]{nrow,ncol,s+1});
                }
            }
        }
        return ans;
    }
}