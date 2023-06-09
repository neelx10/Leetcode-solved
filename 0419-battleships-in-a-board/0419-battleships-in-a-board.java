class Solution {
    public void dfs(char[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='X') return ;
        
        grid[i][j]='#';       //visited mark
		
        dfs(grid,i+1,j);      //down
        dfs(grid,i,j+1);      // right
    }
    public int countBattleships(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){  
                    dfs(grid,i,j);
                    count++;
                }
            } 
        }
        return count;
    }
}








