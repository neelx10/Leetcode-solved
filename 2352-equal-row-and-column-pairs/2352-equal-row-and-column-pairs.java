class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;   
        int count = 0;
        for(int r = 0; r<n; r++) {    
            for(int c = 0; c < n; c++) {         
                int is_equal = 1;
                for(int i = 0; i < n; i++) {   
                    if(grid[r][i] != grid[i][c]) {
                        is_equal = 0;
                        break;
                    }        
                }        
                count += is_equal;          
            }        
        }      
        return count;
    }
}