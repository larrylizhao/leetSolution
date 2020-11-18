package Leetcode.Nov2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        // 从起始点开始BFS分层遍历距离为1的点, 距离为1递增, 从而根据距离对点进行排序
        Queue<PointRC> points = new LinkedList<>();
        PointRC start = new PointRC(r0, c0);
        points.offer(start);
        // 记录已加入的点, 去重
        added[r0][c0] = true;
        // 由起点开始依次查找距离为1的点并加入结果数组
        res.add(new int[]{r0, c0});
        while(!points.isEmpty()) {
            // 分层BFS
            int len = points.size();
            for (int i = 0; i < len; i++) {
                PointRC p = points.poll();
                int r = p.r;
                int c = p.c;

                // 像四个方向寻找合法的距离为一的点并加入结果列表和节点队列
                for (int j = 0; j < 4; j++) {
                    int rn = r + directions[j];
                    int cn = c + directions[j + 1];
                    if(rn > -1 && cn > -1 && rn < R && cn < C && !added[rn][cn] && Math.abs(r - rn) + Math.abs(c - cn) == 1) {
                        res.add(new int[]{rn, cn});
                        added[rn][cn] = true;
                        // 将新的点加入队列, 在下一轮进行寻找与其距离为1的点
                        points.offer(new PointRC(rn, cn));
                    }
                }
            }
        }
        return res.toArray(new int[][]{});
    }

    // R*C的二维数组存储数组下标, 直接对数组下标根据曼哈顿距离排序
    public int[][] allCellsDistOrder_sort(int R, int C, int r0, int c0) {
        // 有R*C个一维数组, 每个一维数组的长度暂未分配
        // 这个二维数组存储了R行C列矩阵的所有坐标点, 坐标点用一维数组表示
        int[][] ret = new int[R * C][];
        // 有R个一维数组, 每个一维数组的长度是C
        // 数组下标代表坐标点, 该二维数组可以和矩阵每个点的值一一对应
        int[][] com = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 每个一维数组是长度为二的一维数组, 表示R*C矩阵中的所有点
                ret[i * C + j] = new int[]{i, j};
//                com[i][j] = i + j;
            }
        }
        // 遍历ret的值(即是12个代表坐标点的一维数组)
        // lambda中对坐标点距离进行排序
        Arrays.sort(ret, Comparator.comparingInt(a -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0))));
//        Arrays.sort(com, Comparator.comparingInt(i -> (-i[0])));
        return ret;
    }

    public static void main(String[] args) {
        MatrixCellsInDistanceOrder matrixCellsInDistanceOrder = new MatrixCellsInDistanceOrder();
        matrixCellsInDistanceOrder.allCellsDistOrder_sort(3,4, 0, 1);
    }
}

// 存储矩阵中的点
class PointRC {
    public int r;
    public int c;

    public PointRC(int x, int y) {
        this.r = x;
        this.c = y;
    }
}
