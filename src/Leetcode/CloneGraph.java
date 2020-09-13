package Leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 133. 克隆图
 * #图 #DFS #BFS
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        List<Node> neighbors = node.neighbors;
        if(neighbors == null || neighbors.isEmpty()){
            return new Node(node.val);
        }
        // 哈希表对应关系，节点1 --> 节点1的克隆
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    //深度优先遍历
    private Node dfs(Node node, Map<Node,Node> lookup) {
        //处理空图
        if (node == null) return null;
        //如果节点被访问过，直接返回该节点的克隆
        if (lookup.containsKey(node)) {
            return lookup.get(node);
        }
        //克隆节点
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors) {
            //依次克隆邻接表
            clone.neighbors.add(dfs(n,lookup));
        }
        return clone;
    }

    //广度优先遍历
    public Node bfs(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        // 将题目给定的节点添加到队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.poll();
            // 遍历该节点的邻居
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}