package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历是先遍历左子树，然后访问根节点，然后遍历右子树。
 * 通常来说，对于二叉搜索树，我们可以通过中序遍历得到一个递增的有序序列。
 */
public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        if(root == null) {
            return inorder;
        }
        if(root.left != null) {
            //递归调用中需要思考如何处理返回值
            inorder.addAll(inorderTraversal(root.left));
        }
        inorder.add(root.val);
        if(root.right != null) {
            inorder.addAll(inorderTraversal(root.right));
        }

        return inorder;
    }
}

