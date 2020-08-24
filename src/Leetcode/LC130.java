package Leetcode;

/**
 * 130. 被围绕的区域
 * 被for循环中的数组下标坑惨了
 * 1. for循环中i < len就已经可以遍历完整个数组。
 *    因为i的最后一个值是len-1, 即是长度为len的数组的最后一个有效下标。
 *    或者你可以写成 i <= len - 1, 更加方便理解
 * 2. for (.....; i++) 这个i++可以理解为整个for循环结束后执行。
 */
public class LC130 {
    public static void main(String[] args) {
        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        LC130 lc130 = new LC130();
        lc130.solve(board);
    }
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return;
        }

        int m = board.length;               //代表矩阵高度, x表示的是矩阵的行
        int n = board[0].length;            //代表矩阵长度, y表示的是矩阵的列
        int[] rows = {0, m-1};
        int[] cols = {0, n-1};

        for (int i = 0; i < m ; i++) {
            for (int col : cols) {
                if(board[i][col] == 'O') {
                    dfs(board, i, col);

                }
            }
        }

        for (int j = 0; j < n ; j++) {
            for (int row : rows) {
                if(board[row][j] == 'O') {
                    dfs(board, row, j);
                }
            }
        }

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int[] direction = {0, 1, 0, -1, 0};
        int m = board.length;               //代表矩阵高度, x表示的是矩阵的行
        int n = board[0].length;            //代表矩阵长度, y表示的是矩阵的列
        board[row][col] = '#';
        for(int i = 0; i < direction.length - 1; i++){
            int nextRow = row + direction[i];
            int nextCol = col + direction[i + 1];
            if(nextRow < m && nextRow > -1 && nextCol < n && nextCol > -1 && board[nextRow][nextCol] == 'O') {
                board[nextRow][nextCol] = '#';
                dfs(board, nextRow, nextCol);
            }
        }
    }
}
