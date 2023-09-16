class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int[][] distance=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=(int)1e9;
            }
        }
        distance[0][0]=0;
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int diff=temp[0],r=temp[1],c=temp[2];
            if(r==m-1 && c==n-1) return diff;
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow<m && nrow>=0 && ncol<n && ncol>=0){
                    int effort=Math.max(diff,Math.abs(heights[nrow][ncol]-heights[r][c]));
                    if(effort<distance[nrow][ncol]){
                        distance[nrow][ncol]=effort;
                        pq.offer(new int[]{effort,nrow,ncol});
                    }
                }
            }
        }
        return -1;
    }
}