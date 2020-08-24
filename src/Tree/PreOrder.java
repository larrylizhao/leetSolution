package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树。
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        //递归具体操作
        if(root == null) {
            return preorder;
        }
        preorder.add(root.val);

        if(root.left != null) {
            //递归入口：思考如何处理返回值
            preorder.addAll(preorderTraversal(root.left));
        }
        if(root.right != null) {
            preorder.addAll(preorderTraversal(root.right));
        }

        //递归出口
        return preorder;
    }

}
