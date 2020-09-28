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
     * 从ArrayList中构建二叉树, ArrayList中不可以有空值
     * 一个由数组构建的完全二叉树，若某个节点在数组中的下标为n。
     * 则其左子节点下标为2n+1, 右子节点的下标为2n+2
     * @param arr 需要构建的数组
     * @return 所构建二叉树的根节点
     */
    private TreeNode createTreeFromNotNullList(List<Integer> arr, int n) {
        if(n >= arr.size()) {
            return null;
        }
        TreeNode root = new TreeNode(arr.get(n));
        root.left = createTreeFromNotNullList(arr, 2 * n + 1);
        root.right = createTreeFromNotNullList(arr, 2 * n + 2);
        return root;
    }

    /**
     * 将构建的二叉树赋值给跟节点
     * @param arr 需要构建的数组
     */
    public void createTreeFromNotNullList(List<Integer> arr) {
        root = createTreeFromNotNullList(arr, 0);
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

    /**
     * 从LinkedList中构建二叉树，LinkedList中可以有空值
     * @param integerQueue 需要构造成二叉树的队列，可包含空值
     * @return 二叉树的根节点
     */
    public static TreeNode createTree(Queue<Integer> integerQueue) {
        if (integerQueue == null || integerQueue.peek() == null) {
            return null;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        TreeNode treeNode = new TreeNode(integerQueue.poll());
        treeNodeQueue.offer(treeNode);

        // treeNodeQueue中的每个有效节点对应integerQueue中的两个节点
        while (!integerQueue.isEmpty() && treeNodeQueue.peek() != null){
            Integer leftVal = integerQueue.poll();
            Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            TreeNode current = treeNodeQueue.poll();
            if (leftVal != null) {
                TreeNode left = new TreeNode(leftVal);
                current.left = left;
                treeNodeQueue.offer(left);
            }
            if (rightVal != null){
                TreeNode right = new TreeNode(rightVal);
                current.right = right;
                treeNodeQueue.offer(right);
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        List<Integer> arr = Arrays.asList(1, 2, null, 3, 4, 5, 6, 7);
        Queue<Integer> integerQueue = new LinkedList<>(Arrays.asList(5,null,null,11,null,17,4,7,null,null,null,5));
        BinaryTree.createTree(integerQueue);
//        binaryTree.getTreeFromList(arr);
//        System.out.println(binaryTree.levelOrderTraverse());
    }

}

