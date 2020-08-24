package Leetcode;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        /*
        这样做是有问题的，会使得首节点相同就退出（相当于开了两个退出的口子）
        if(p.val == q.val) {
            return true;
        }
         */

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
