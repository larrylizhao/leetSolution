package Leetcode.Mar2022;

import java.util.ArrayList;
import java.util.List;

/*
    590. N 叉树的后序遍历
    #树 #递归
 */
public class NaryTreePostorderTraversal {
    /*
        返回N叉树的后序遍历
        每组子节点由空值null分隔
        输入：root = [1,null,3,2,4,null,5,6]
        输出：[5,6,3,2,4,1]
     */
    public List<Integer> postorder(Node root) {
        List<Integer> postorderList = new ArrayList<Integer>();
        if(root == null) {
            return postorderList;
        }
        for (Node child : root.children) {
            if(child != null) {
                // 递归获取子节点的后序遍历
                postorderList.addAll(postorder(child));
            }
        }
        // 最后添加根节点
        postorderList.add(root.val);
        return postorderList;
    }

    static class Node {
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
    }
}



