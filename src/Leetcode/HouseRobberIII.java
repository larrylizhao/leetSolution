package Leetcode;

/**
 * 337. 打家劫舍III
 * https://leetcode-cn.com/problems/house-robber-iii/
 * #树 #递归 #DFS
 */
public class HouseRobberIII {
    /*
        如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
        输入: [3,2,3,null,3,null,1]

             3
            / \
           2   3
            \   \
             3   1

        输出: 7
        解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     */
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int money = root.val;

        if(root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right != null) {
            money += rob(root.right.left) + rob(root.right.left);
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }
}
