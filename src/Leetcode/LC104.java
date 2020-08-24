package Leetcode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class LC104 {

    public int maxDepth(TreeNode root) {
        //终止条件是节点为null
        if (root == null) {
            return 0;
        }

        //该树的最大深度是左边的最大深度与右边的最大深度之中较大者再加一
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        //return dfs(root);
    }

    private int dfs(TreeNode node) {
        int lenLeft  = 1;
        int lenRight = 1;
        //分别统计左右子树的递归次数（递归0次就是1，递归一次就是递归0次加上1即2）
        //通过递归次数统计树高，并选择左右树高的最大值
        if (node.left != null) {
            lenLeft = dfs(node.left) + 1;
        }
        if (node.right != null) {
            lenRight = dfs(node.right) + 1;
        }
        return Math.max(lenLeft, lenRight);
    }

}
