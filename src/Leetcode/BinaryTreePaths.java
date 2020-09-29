package Leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.BinaryTree;
import Tree.TreeNode;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * #树 #DFS #回溯
 */
public class BinaryTreePaths {
    /*
        输入:

           1
         /   \
        2     3
         \
          5

        输出: ["1->2->5", "1->3"]
        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, new StringBuilder());
        return res;
    }

    /*
    显式回溯:
        因为传入的参数是StringBuilder可变（后续递归中会重复利用并改变sb的值），所以要注意回溯
        如果传入的是string则不需要回溯，因为string每次都会创建新的，所以后续递归不会对之前结果造成影响。所以不需要撤销选择
     */
    private void dfs(TreeNode node, List<String> res, StringBuilder sb) {
        if(node == null) {
            return;
        }
        sb.append(node.val);
        // 判断是否到达叶子节点
        if(node.left == null && node.right == null) {
            res.add(sb.toString());
            // 回溯: return前撤销之前的选择
            sb.delete(sb.lastIndexOf("->") + 2, sb.length());
            return;
        }
        sb.append("->");
        dfs(node.left, res, sb);
        dfs(node.right, res, sb);
        // 回溯: 在return前撤销本轮所做的所有选择
        sb.delete(sb.lastIndexOf("->"), sb.length());
        sb.delete(sb.lastIndexOf("->") + 2, sb.length());
    }

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
//        Queue<Integer> integerQueue = new LinkedList<>(Arrays.asList(37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8));
        Queue<Integer> integerQueue = new LinkedList<>(Arrays.asList(1, 2, 3, null, 5));
        TreeNode root = BinaryTree.createTree(integerQueue);
        List<String> res = binaryTreePaths.binaryTreePaths(root);
        System.out.println(res);
    }
}
