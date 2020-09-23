package Leetcode;

/**
 * 617. 合并二叉树
 * #树 #DFS
 */
public class MergeTwoBinaryTrees {
    /*
        输入:
	    Tree 1                     Tree 2
              1                         2
             / \                       / \
            3   2                     1   3
           /                           \   \
          5                             4   7
        输出:
        合并后的树:
        	     3
        	    / \
        	   4   5
        	  / \   \
        	 5   4   7

     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }

        if(t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
