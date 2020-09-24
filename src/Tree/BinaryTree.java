package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    TreeNode root;

    public TreeNode getTree() {
        return root;
    }

    /**
     * 从ArrayList中构建二叉树。
     * 一个由数组构建的完全二叉树，若某个节点在数组中的下标为n。
     * 则其左子节点下标为2n+1, 右子节点的下标为2n+2
     * @param arr 需要构建的数组
     * @return 所构建二叉树的根节点
     */
    private TreeNode getTreeFromList(List<Integer> arr, int n) {
        if(n >= arr.size()) {
            return null;
        }
        TreeNode root = new TreeNode(arr.get(n));
        root.left = getTreeFromList(arr, 2 * n + 1);
        root.right = getTreeFromList(arr, 2 * n + 2);
        return root;
    }

    /**
     * 将构建的二叉树赋值给跟节点
     * @param arr 需要构建的数组
     */
    public void getTreeFromList(List<Integer> arr) {
        root = getTreeFromList(arr, 0);
    }

    public List<Integer> levelOrderTraverse() {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<> ();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            res.add(node.val);
            if(node.left != null) {
                nodes.offer(node.left);
            }
            if(node.right != null) {
                nodes.offer(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        binaryTree.getTreeFromList(arr);
        System.out.println(binaryTree.levelOrderTraverse());
    }

}

