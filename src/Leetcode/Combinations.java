package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * #回溯
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        // 从 1 开始是题目的设定
        dfs(n, k, 1, path, res);
        return res;
    }

    /**
     * 遍历可能的搜索起点, 探索当前节点下所有可能的组合
     * @param n 数的范围
     * @param k 选择多少个数
     * @param begin 探索起点
     * @param path 可能路径
     * @param res 合法结果
     */
    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 找到了一个可能存在的正确答案
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点, 探索当前节点下所有可能的组合
        for (int i = begin; i <= n; i++) {
            // 向路径中里添加一个数, 并向下查找以此数为跟节点的所有情况
            path.addLast(i);

            // 下一轮搜索，设置的搜索起点要加 1，探索除去已加入path外的所有情况
            // 在已经选择了一些数的前提下，在剩下的还没有选择的数中，依次选择一个数
            dfs(n, k, i + 1, path, res);

            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            // 已找到或在尝试了所有可能的分步方法后宣告该问题没有答案，此时回退并探索其他路径
            path.removeLast();
        }
    }
}
