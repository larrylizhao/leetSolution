package Leetcode.oct2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 834. 树中距离之和
 * #树 #DFS #动态规划 #图
 *
 */
public class SumOfDistancesInTree {
    /*
        输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
        输出: [8,12,6,10,10,10]
        解释:
        如下为给定的树的示意图：
          0
         / \
        1   2
           /|\
          3 4 5
        
        我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
        也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
     */
    /*
        dp[child] = dp[parent] + 1 * #y - 1 * #x
        #y: child子树以外的节点数量, 因为外面的要多走一步
        #x: child子树节点数量(包括自己), 因为child子树所有节点都少走一步
        #x + #y = N (整个树的节点数量)
     */
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] nodeSum = new int[N];
        int[] ans = new int[N];
        // 把edges表示转换为临接表
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if(graph.containsKey(x)) {
                graph.get(x).add(y);
            } else {
                List<Integer> child = new ArrayList<>();
                child.add(y);
                graph.put(x, child);
            }

            if(graph.containsKey(y)) {
                graph.get(y).add(x);
            } else {
                List<Integer> child = new ArrayList<>();
                child.add(x);
                graph.put(y, child);
            }
        }

        // 计算每个节点的子节点数量并加上自己 #x
        for (int i = 0; i < N - 1; i++) {
            nodeSum[i] = graph.get(i).size() + 1;
        }

        // 计算ans[0]
        ans[0] = 0;
        Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(0);
        int level = 1;
        while(!nodes.isEmpty()){
            int node = nodes.poll();
            List<Integer> children = graph.get(node);
            for (Integer child : children) {
                nodes.offer(child);
            }
            ans[0] += level * graph.get(node).size();
        }

        dfs(0, graph, ans, N, nodeSum);

        return ans;
    }

    private void dfs(int node, Map<Integer, List<Integer>> graph, int[] ans, int n, int[] nodeSum) {
        List<Integer> children = graph.get(node);
        for(Integer child : children) {
            ans[child] = ans[node] + n - 2 * nodeSum[child];
            dfs(child, graph, ans, n, nodeSum);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int n = 6;
        SumOfDistancesInTree sumOfDistancesInTree = new SumOfDistancesInTree();
        sumOfDistancesInTree.sumOfDistancesInTree(n, edges);
    }
}
