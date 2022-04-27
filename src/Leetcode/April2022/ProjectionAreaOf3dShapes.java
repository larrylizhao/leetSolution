package Leetcode.April2022;

import java.util.Arrays;

/**
 * 883. 三维形体投影面积
 * #
 */
public class ProjectionAreaOf3dShapes {
    /*
        
     */
    public int projectionArea(int[][] grid) {
        int xy = 0;
        int xz = 0;
        int[] maxInCol = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int maxInRow = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    maxInRow = Math.max(maxInRow, grid[i][j]);
                    maxInCol[j] = Math.max(grid[i][j], maxInCol[j]);
                    xy++;
                }
            }
            xz += maxInRow;
        }
        return xy + xz + Arrays.stream(maxInCol).sum();
    }
}
