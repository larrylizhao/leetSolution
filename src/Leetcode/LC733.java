package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. 图像渲染
 */
public class LC733 {

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill_bfs(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        //保存当前坐标
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    //保存合法的下一个坐标
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor != newColor) {
            image[sr][sc] = newColor;
            dfs(image, sr, sc, oldColor, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        int[] directions = {0, 1, 0, -1, 0};
        int rows = image.length;;
        int cols = image[0].length;

        for(int i=0; i<directions.length - 1; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];
            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == oldColor) {
                image[newRow][newCol] = newColor;
                dfs(image, newRow, newCol, oldColor, newColor);
            }
        }
    }
}
