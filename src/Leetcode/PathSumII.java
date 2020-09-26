package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * #树 #DFS #回溯 #树形回溯
 */
public class PathSumII {
    /*
        示例:
        给定如下二叉树，以及目标和sum = 22，

                      5
                     / \
                    4   8
                   /   / \
                  11  13  4
                 /  \    / \
                7    2  5   1
        返回:

        [
           [5,4,11,2],
           [5,8,4,5]
        ]
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> res, List<Integer> path) {
        // 空节点直接返回
        if(node == null) {
            return;
        }
        path.add(node.val);
        // 到达叶子节点时进行判断, 如果是合法解，将path加入res列表，并返回
        if(node.val == sum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
            // return之前要进行回溯, 撤销这个递归体内的选择
            path.remove(path.size() - 1);
            return;
        }
        // 如果既没有退出也没有达到叶子节点，就需要分别沿着左右子树两个方向找
        dfs(node.left, sum - node.val, res, path);
        dfs(node.right, sum - node.val, res, path);
        path.remove(path.size() - 1);
    }
}
