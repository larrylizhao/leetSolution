package Tree;


/**
 * 二叉搜索树:
 */
public class BinarySearchTree {

    /**
     * 验证是否是合法的二叉搜索树
     * @param root
     * @return
     */
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    /**
     *
     * @param root TreeNode
     * @param val int
     * @return 插入新节点后的二叉搜索树
     */
    TreeNode insertNode(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(val < root.val) {
            root.left = insertNode(root.left, val);
        }
        if(val > root.val) {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

}
