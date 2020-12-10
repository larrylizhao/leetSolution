package Leetcode.Dec2020;

/**
 *  62. 不同路径
 *  #动态规划
 */
public class UniquePath {
    /*
        一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
        问总共有多少条不同的路径？

        输入: m = 3, n = 2 (3 cols, 2 rows)
        输出: 3
        解释:
        从左上角开始，总共有 3 条路径可以到达右下角。
        1. 向右 -> 向右 -> 向下
        2. 向右 -> 向下 -> 向右
        3. 向下 -> 向右 -> 向右
     */
    /*
        每一个格子只能由它相邻的上面或左面的格子走到，距离为1
        dp[x][y] = dp[x-1][y] + dp[x][y-1] (考虑越界情况, 越界则为0)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        return 0;
    }
}












