package Leetcode.oct2020;

import java.util.ArrayList;
import java.util.List;

import Leetcode.TreeNode;

/**
 * 144. 二叉树的前序遍历
 * #树 #二叉树
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
