package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    ArrayList<String> vertexes;
    int[][] edges;
    int numOfEdges;

    // Constructor
    public Graph(int n) {
        vertexes = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
    }

    public void insertVertex(String vertex) {
        vertexes.add(vertex);
    }

    /**
     * 插入图的边
     * @param v1 int 第一个顶点对应的下标
     * @param v2 int 第二个顶点对应的下标
     * @param weight int 这条边的权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public void delete(String vertex) {

    }

    public int numOfVertexes() {
        return vertexes.size();
    }

    public int numOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int idx) {
        return vertexes.get(idx);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void printGraph() {
        for(int[] links : edges) {
            System.out.println(Arrays.toString(links));
        }
    }

    public static void main(String[] args) {
        int n = 5;
        String[] vertexes = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);

        // 添加顶点
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }

        // 添加边 A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.printGraph();
    }
}
