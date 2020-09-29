package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * #树
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if(node == null) {
            return;
        }
        dfs(node.left, res);
        dfs(node.right, res);
        res.add(node.val);
    }

    /*
        颜色标记法
        1. 将根节点标记为白色并入栈
        2. 栈为非空则循环
            2.1 出栈, 如果节点是null, continue跳过当前循环
            2.2 如果节点是白色则将节点标记为灰色并将其左右子节点标记为白色。
            2.2 按照需要的顺序压栈
            2.3 如果节点是灰色则加入目标列表
        3. 返回列表
     */
    public List<Integer> postorderTraversal_color(TreeNode root) {
        int WHITE = 0;
        int GREY = 1;
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, Integer> nodeWithColor = new HashMap<>();
        Stack<TreeNode> nodes = new Stack<> ();
        // 用于记录每个节点颜色
        nodeWithColor.put(root, WHITE);
        nodes.push(root);
        while(!nodes.empty()) {
            TreeNode node = nodes.pop();
            if(node == null) {
                continue;
            }
            int color = nodeWithColor.get(node);
            // 当前节点为白色，则将其标记为灰色
            if(color == WHITE) {
                nodeWithColor.put(node, GREY);
                nodeWithColor.put(node.left, WHITE);
                nodeWithColor.put(node.right, WHITE);
                // 出栈顺序: 先左后右再中间
                nodes.push(node);
                nodes.push(node.right);
                nodes.push(node.left);
            } else {
                // 当前节点为灰色，则将该节点加入到答案列表
                res.add(node.val);
            }
        }
        return res;
    }
}
