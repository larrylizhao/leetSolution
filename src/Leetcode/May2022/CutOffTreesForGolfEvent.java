package Leetcode.May2022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  675. 为高尔夫比赛砍树
 *  #BFS
 */
public class CutOffTreesForGolfEvent {
    int N = 50;
    int[][] golf = new int[N][N];
    int n, m;
    List<int[]> list = new ArrayList<>();
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    /*
     *  路径由低到高且树的高度都不同，所以路径唯一确定
     *  对树排序后，依次计算两两之间的最短距离
     */
    public int cutOffTree(List<List<Integer>> forest) {
        n = forest.size();
        m = forest.get(0).size();

        // 把forest转为二维数组golf
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                golf[i][j] = forest.get(i).get(j);
                // 记录树的高度及坐标
                if (golf[i][j] > 1) {
                    list.add(new int[]{ golf[i][j], i, j});
                }
            }
        }
        // 对树进行排序
        list.sort((a, b) -> a[0] - b[0]);
        if (golf[0][0] == 0) return -1;
        int x = 0, y = 0, ans = 0;
        // 依题意从最矮的树开始走，算出两两点之间的最小距离并叠加
        for (int[] tree : list) {
            int tx = tree[1];
            int ty = tree[2];
            int d = bfs(x, y, tx, ty);
            if (d == -1) return -1;
            ans += d;
            x = tx; y = ty;
        }
        return ans;
    }

    // bfs 计算两点的最小距离
    int bfs(int X, int Y, int P, int Q) {
        if (X == P && Y == Q) return 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{X, Y});
        visited[X][Y] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 逐层向外找 nx == p && ny == Q 的点
            while (size-- > 0) {
                int[] tree = queue.poll();
                int x = tree[0], y = tree[1];
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (golf[nx][ny] == 0 || visited[nx][ny]) continue;
                    if (nx == P && ny == Q) return ans + 1;
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}