package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II
 * #BFS
 */
public class BinaryTreeLevelOrderTraversal2 {
    // 倒序输出二叉树的层序值
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        //传入第一层
        levelOrderTraversal(nodes, res);
        return res;
    }

    //获取队列中所有节点的值与节点的子节点队列，并递归调用
    private void levelOrderTraversal(Queue<TreeNode> parentLevels, List<List<Integer>> res) {
        //终止条件
        if(parentLevels.isEmpty()) {
            return;
        }
        Queue<TreeNode> childLevels = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        while(!parentLevels.isEmpty()) {
            TreeNode parent = parentLevels.poll();
            level.add(parent.val);
            //获得层序子节点
            if(parent.left != null) {
                childLevels.offer(parent.left);
            }
            if(parent.right != null) {
                childLevels.offer(parent.right);
            }
        }
        // 获得层序值
        res.add(0, level);
        //递归处理层序
        levelOrderTraversal(childLevels, res);
    }
}

//先把知道的（必须用到的）部分写出来，然后借助已知的步骤去拼凑如何达到结果
