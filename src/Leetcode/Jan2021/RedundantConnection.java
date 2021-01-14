package Leetcode.Jan2021;

/**
 *  684. 冗余连接
 *  #图 #并查集
 */
public class RedundantConnection {
    /*
        输入一个图，该图由一个有着N个节点的树和一条附加边组成
        返回一条可以删去的边，使得结果图是一个有着N个节点的树。
        如果有多个答案，则返回二维数组中最后出现的边。

        输入: [[1,2], [1,3], [2,3]]
        输出: [2,3]
        解释: 给定的无向图为:
          1
         / \
        2 - 3

        输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
        输出: [1,4]
        解释: 给定的无向图为:
        5 - 1 - 2
            |   |
            4 - 3
     */
    public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            // 如果不相连，就将他们相连，如果新的edge已经相连，则这条edge就是多余的边，删除这条边可以形成树
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    // 将index1的parent设置为index2, 即表示将index1 与 index2 连通
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    // 父节点不为自己的时候, 继续向上查找。 连通分量的父节点一定是自己
    public int find(int[] parent, int index) {
        while(parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}
