package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历是先遍历左子树，然后遍历右子树，最后访问树的根节点。
 *
 * 当你删除树中的节点时，删除过程将按照后序遍历的顺序进行。
 * 也就是说，当你删除一个节点时，你将首先删除它的左节点和它的右边的节点，然后再删除节点本身。
 */
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();

        if (root == null) {
            return postorder;
        }
        if (root.left != null) {
            postorder.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            postorder.addAll(postorderTraversal(root.right));
        }
        postorder.add(root.val);

        return postorder;
    }
}
