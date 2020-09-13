package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 637. 二叉树的层平均值
 * #层序遍历
 */
public class AverageOfLevelsInBinaryTree {
    // 计算二叉树每一层的平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 广度优先遍历
        while (!queue.isEmpty()) {
            // 每层节点数
            int len = queue.size();
            double sum = 0;
            // 计算每一层的平均值
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                //将当前层的子节点加入到队列中
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            Double avg = sum / len;
            res.add(avg);
        }

        return res;
    }

    public List<Double> averageOfLevels_dfs(TreeNode root) {
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    private void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }

        //如果已经遍历过当前层
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            //还未遍历过当前层
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }
}
