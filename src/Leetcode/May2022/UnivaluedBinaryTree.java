package Leetcode.May2022;

import Tree.TreeNode;

/**
 *  965. 单值二叉树
 *  #树 #遍历
 */
public class UnivaluedBinaryTree {
    boolean isUnivalued = true;
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return true;
        }

        dfs(root.left, root.val);
        dfs(root.right, root.val);
        return isUnivalued;
    }

    private void dfs(TreeNode node, int val) {
        if(node == null) return;
        if(node.val != val) {
            isUnivalued = false;
            return;
        }
        dfs(node.left, val);
        dfs(node.right, val);
    }
}
