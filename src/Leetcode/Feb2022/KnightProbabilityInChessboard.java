package Leetcode.Feb2022;

/**
 * 688. 骑士在棋盘上的概率
 * #记忆化搜索 #动态规划
 */
public class KnightProbabilityInChessboard {
    /*
        骑士移动k次后依然在棋盘内的概率
        输入: n = 3, k = 2, row = 0, column = 0
        输出: 0.0625
        解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
    */
    int[][] dirs = new int[][]{{-1,-2},{-1,2},{1,-2},{1,2},{-2,1},{-2,-1},{2,1},{2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] f = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][0] = 1;
            }
        }
        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : dirs) {
                        int nx = i + d[0], ny = j + d[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        f[i][j][p] += f[nx][ny][p - 1] / 8;
                    }
                }
            }
        }
        return f[row][column][k];
    }

    public static void main(String[] args) {
        KnightProbabilityInChessboard knightProbabilityInChessboard = new KnightProbabilityInChessboard();
        int n = 5;
        int k = 3;
        int row = 0;
        int column = 0;
        double result = knightProbabilityInChessboard.knightProbability(n, k, row, column);
        System.out.println(result);
    }

}
