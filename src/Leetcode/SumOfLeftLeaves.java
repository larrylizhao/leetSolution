package Leetcode;

/**
 * 404. 左叶子之和
 * #递归
 */
public class SumOfLeftLeaves {
    /*
            3
           / \
          9  20
            /  \
           15   7
        在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false, 0);
    }

    // 递归只关心当下
    private int dfs(TreeNode node, boolean isLeft, int res) {
        if (node == null) {
            return 0;
        }
        // 如果是左叶子节点, 返回累加之后的值
        if(isLeft && node.left == null && node.right == null) {
            res += node.val;
            return res;
        }
        // 根节点的答案是左子树和右子树答案之和
        return dfs(node.left, true, res) + dfs(node.right, false, res);
    }
}
