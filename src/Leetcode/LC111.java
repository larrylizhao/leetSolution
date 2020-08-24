package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 */
public class LC111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        //为null的子节点高度是0，不能参与比较
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

    class QueueNode {
        private final TreeNode node;
        private final int depth;
        QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
        public TreeNode getNode() {
            return node;
        }
        public int getDepth() {
            return depth;
        }
    }

    public int minDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> leaves = new LinkedList<>();
        //用QueueNode记录节点对应的高度
        QueueNode queueNode = new QueueNode(root, 1);
        leaves.offer(queueNode);
        while (!leaves.isEmpty()) {
            QueueNode node = leaves.poll();
            TreeNode treeNode = node.getNode();
            int depth = node.getDepth();

            //到达第一个叶子节点后即可返回高度，是最小高度
            if (treeNode.left == null && treeNode.right == null) {
                return depth;
            }

            //否则把叶子结点加入队列，并记录该节点当前高度
            if (treeNode.left != null) {
                leaves.offer(new QueueNode(treeNode.left, depth + 1));
            }
            if (treeNode.right != null) {
                leaves.offer(new QueueNode(treeNode.right, depth + 1));
            }
        }
        return Integer.MAX_VALUE;
    }
}

