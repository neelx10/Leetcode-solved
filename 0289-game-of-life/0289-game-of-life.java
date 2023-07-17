class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] temp=new int[m][n];
        // Create a deep copy of the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board[i][j];
            }
        }
        
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                for (int k = 0; k < 8; k++) {
                    int row = i + dr[k];
                    int col = j + dc[k];
                    if (row >= 0 && row < m && col >= 0 && col < n && temp[row][col] == 1) liveCount++;
                }
                if (temp[i][j] == 0) {
                    if (liveCount == 3) board[i][j] = 1;
                } 
                else {
                    if (liveCount < 2 || liveCount > 3) board[i][j] = 0;
                }
            }
        }
    }
}