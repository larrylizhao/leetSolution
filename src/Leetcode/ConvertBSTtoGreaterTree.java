package Leetcode;

/**
 * 538. 把二叉搜索树转换为累加树
 * #树
 */
public class ConvertBSTtoGreaterTree {
    /*
    给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

    输入: 原始二叉搜索树:
              5
            /   \
           2     13

    输出: 转换为累加树:
             18
            /   \
          20     13
     */
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum += dfs(node.right, sum);
        sum += node.val;
        node.val = sum;
        sum += dfs(node.left, sum);
        return sum;
    }
}
