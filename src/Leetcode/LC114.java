package Leetcode;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class LC114 {

    //递归的把左子树插入root和右子节点之间
    public void flatten(TreeNode root) {
        while(root != null) {
            flatTree(root);
            root = root.right;
        }
    }

    private void flatTree(TreeNode root) {
        //将左子树插入到根节点和右子树之间
        if(root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            getRightMostNode(root.left).right = temp;
        }
    }

    private TreeNode getRightMostNode(TreeNode root) {
        if(root == null) {
            return null;
        }
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }
}
