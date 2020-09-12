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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 广度优先遍历
        while(!queue.isEmpty()) {
            // 每层节点数
            int len = queue.size();
            double sum = 0;
            // 计算每一层的平均值
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                //将当前层的子节点加入到队列中
                if(node.left != null) {
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
}
