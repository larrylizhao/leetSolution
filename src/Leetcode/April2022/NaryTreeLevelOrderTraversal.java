package Leetcode.April2022;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Leetcode.NaryNode;


/**
 *  429. N 叉树的层序遍历
 *  #树 #BFS
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NaryNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<NaryNode> queue = new LinkedList<>();
        if(root == null) {
            return result;
        }
        // 根节点入队
        queue.offer(root);
        // 以null为每一层的分割点
        queue.offer(null);
        while(!queue.isEmpty()) {
            NaryNode node = queue.poll();
            List<Integer> level = new ArrayList<>();
            // 遇到null之前说明当前节点全部为同一层
            while(node != null) {
                level.add(node.val);
                List<NaryNode> children = node.children;
                queue.addAll(children);
                node = queue.poll();
            }
            // 避免无限循环
            if (level.size() > 0) {
                queue.offer(null);
                result.add(level);
            }
        }
        return result;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/