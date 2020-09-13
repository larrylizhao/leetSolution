package Leetcode;

/**
 * 329. 矩阵中的最长递增路径
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * #DFS #回溯 #记忆化搜索
 */
public class LongestIncreasingPathInMatrix {
    /*
    输入: nums =
    [
      [9,9,4],
      [6,6,8],
      [2,1,1]
    ]
    输出: 4
    解释: 最长递增路径为 [1, 2, 6, 9]。
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int         m       = matrix.length;
        int         n       = matrix[0].length;
        int[][]     res     = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int         max     = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, res, visited, i, j));
            }
        }
        return max;
    }

    // 获取{x,y}节点所可以走的最大长度
    private int dfs(int[][] matrix, int[][] res, boolean[][] visited, int x, int y) {
        // 已经探索过该节点，直接返回该节点的最长递增路径长度
        if (res[x][y] != 0) {
            return res[x][y];
        }
        //在当前DFS遍历中，该节点是起点，标记为已经访问
        visited[x][y] = true;
        int depth = 0;
        //代表四个方向
        int[] direction = { 0, 1, 0, -1, 0 };
        int   m         = matrix.length;
        int   n         = matrix[0].length;
        for (int i = 0; i < 4; i++) {
            int nx = x + direction[i];
            int ny = y + direction[i + 1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[x][y] && !visited[nx][ny]) {
                //每个方向上的depth也会进行比较，保留最大值
                depth = Math.max(depth, dfs(matrix, res, visited, nx, ny));
            }
        }
        // 四个方向上都无法继续DFS，当前节点无效，进行回溯
        // 上层调用for循环保证不会再来到该节点
        visited[x][y] = false;

        //就算每个方向都走不通，长度也是1（即该节点本身）
        //depth赋值为0再加1而不直接赋值为1的好处是可以记录深度
        res[x][y] = depth + 1;
        return res[x][y];
    }

}
