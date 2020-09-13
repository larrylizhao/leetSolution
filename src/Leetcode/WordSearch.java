package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 79. 单词搜索
 * #DFS #回溯
 */
public class WordSearch {
    /* 示例
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0] == null || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean exist = false;
        char[] words = word.toCharArray();
        char firstChar = words[0];
        List<int[]> starter = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;
        //取得起始点坐标: 矩阵中word首字母的坐标
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == firstChar) {
                    starter.add(new int[]{ i, j });
                }
            }
        }
        for (int[] startPoint : starter) {
            boolean[][] vis = new boolean[row][col];
            int startRow = startPoint[0];
            int startCol = startPoint[1];
            vis[startRow][startCol] = true;
            if(dfs(board, words, startRow, startCol, 1, vis)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int row, int col, int position, boolean[][] vis) {
        if(position == words.length) {
            return true;
        }
        int[] direction = {0, -1, 0, 1, 0};
        int rows = board.length;
        int cols = board[0].length;

        boolean exist = false;
        for ( int i = 0; i < direction.length - 1; i++) {
            int nextRow = row + direction[i];
            int nextCol = col + direction[i+1];
            if(nextRow >= 0 && nextRow < rows && nextCol >=0 && nextCol < cols && !vis[nextRow][nextCol] && board[nextRow][nextCol] == words[position]) {
                vis[nextRow][nextCol] = true;
                //四个方向上有一个true，结果就是true
                exist = exist || dfs(board, words, nextRow, nextCol, position + 1, vis);
                // IMPORTANT: 当一个方向行不通的时候回退的时候要回溯
                vis[nextRow][nextCol] = false;
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        boolean res = wordSearch.exist(board, word);
        System.out.println(res);
    }
}


