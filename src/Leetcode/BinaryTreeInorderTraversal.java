package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            dfs(root.left, res);
        }
        res.add(root.val);
        if(root.right != null) {
            dfs(root.right, res);
        }
    }
}
