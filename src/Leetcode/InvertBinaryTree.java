package Leetcode;

/**
 * 226. 翻转二叉树
 * #树 #递归
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        // 递归出口
        if (root == null) {
            return null;
        }

        // 处理递归返回值
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
