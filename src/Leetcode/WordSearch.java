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
            if(dfs(board, words, startRow, startCol, 1, vis)) {
                return true;
            }
        }
        return false;
    }

    // 我们在写递归函数时，关注当前，当前考察的点，哪些是当前递归该处理的，哪些是丢给递归子调用去做的
    // 当前递归本身做的事: 判断当前选择的点，本身有没有问题，是不是错的。
    private boolean dfs(char[][] board, char[] words, int row, int col, int position, boolean[][] vis) {
        vis[row][col] = true;
        if(position == words.length) {
            return true;
        }
        int[] direction = {0, -1, 0, 1, 0};
        int rows = board.length;
        int cols = board[0].length;

        // 如果四个方向上都无法继续递归, 说明当前点是错的, 直接回溯并返回false
        for ( int i = 0; i < direction.length - 1; i++) {
            int nextRow = row + direction[i];
            int nextCol = col + direction[i+1];
            if(nextRow >= 0 && nextRow < rows && nextCol >=0 && nextCol < cols && !vis[nextRow][nextCol] && board[nextRow][nextCol] == words[position]) {
                // 可以继续递归说名当前节点没问题
                if(dfs(board, words, nextRow, nextCol, position + 1, vis)) {
                    //四个方向上有一个true，结果就是true
                    return true;
                }
            }
        }

        // 回溯
        // 上层递归的for循环可以保证不会再次走入次错误节点
        vis[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        boolean res = wordSearch.exist(board, word);
        System.out.println(res);
    }
}


