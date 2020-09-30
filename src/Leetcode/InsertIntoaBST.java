package Leetcode;

/**
 * 701. 二叉搜索树中的插入操作
 * #树 #递归
 */
public class InsertIntoaBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
