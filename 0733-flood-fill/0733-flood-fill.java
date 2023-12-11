class Solution {
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        image[sr][sc]=newColor;
        for(int i=0;i<4;i++){
            int nrow=sr+dr[i],ncol=sc+dc[i];
            if(nrow>=0 && ncol>=0 && nrow<image.length && ncol<image[0].length && image[nrow][ncol]==oldColor) dfs(image,nrow,ncol,newColor,oldColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color!=image[sr][sc]) dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}