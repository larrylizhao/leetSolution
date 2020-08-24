package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 */
public class LC99 {
    public void recoverTree(TreeNode root) {

    }

    List<TreeNode> inorderTraverse(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<TreeNode> rtn = new ArrayList<>(inorderTraverse(root.left));
        rtn.add(root);
        rtn.addAll(inorderTraverse(root.right));
        return rtn;
    }

}
