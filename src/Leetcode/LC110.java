package Leetcode;


/**
 * 110. 平衡二叉树
 * 一个二叉树中每个节点的左右两个子树的高度差的绝对值不超过1。
 */
public class LC110 {

    /**
     * 通过-1来标记某个子树不为平衡二叉树，并将此向上传递
     * 最终结果不为-1证明所有子树都为平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced_height(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        //若该节点不是平衡二叉树，则标记高度为-1
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
