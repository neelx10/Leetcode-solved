class Solution {
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, -1, 0, 1};

    public boolean dfs(int row, int col, char[][] board, String word, int idx) {
        if (idx == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(idx))
            return false;

        char temp = board[row][col];
        board[row][col] = '#';

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (dfs(nrow, ncol, board, word, idx + 1)) return true;
        }

        board[row][col] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, board, word, 0)) return true;
            }
        }

        return false;
    }
}
