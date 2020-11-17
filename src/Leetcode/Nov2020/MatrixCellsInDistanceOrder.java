package Leetcode.Nov2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  1030. 距离顺序排列矩阵单元格
 *  #二维数组 #数组
 */
public class MatrixCellsInDistanceOrder {
    /*
        给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。

        另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。

        返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排.
        其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）

        输入：R = 2, C = 2, r0 = 0, c0 = 1
        输出：[[0,1],[0,0],[1,1],[1,0]]
        解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
        [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] added = new boolean[R][C];
        List<int[]> res = new ArrayList<>();
        int[] directions = new int[]{0, 1, 0, -1, 0};
        Queue<PointRC> points = new LinkedList<>();
        PointRC start = new PointRC(r0, c0);
        points.offer(start);
        res.add(new int[]{r0, c0});
        added[r0][c0] = true;
        // 由起点开始依次查找距离为1的点并加入结果数组
        while(!points.isEmpty()) {
            int len = points.size();
            for (int i = 0; i < len; i++) {
                PointRC p = points.poll();
                int r = p.r;
                int c = p.c;

                for (int j = 0; j < 4; j++) {
                    int rn = r + directions[j];
                    int cn = c + directions[j + 1];
                    if(rn > -1 && cn > -1 && rn < R && cn < C && !added[rn][cn] && Math.abs(r - rn) + Math.abs(c - cn) == 1) {
                        res.add(new int[]{rn, rn});
                        added[rn][cn] = true;
                    }
                }
            }
        }
        return res.toArray(new int[][]{});
    }
}

class PointRC {
    public int r;
    public int c;

    public PointRC(int x, int y) {
        this.r = x;
        this.c = y;
    }
}
