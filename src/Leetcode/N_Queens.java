package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后
 * #回溯 #二维数组 #数组下标
 *
 * 这道题必须完全记录过去的选择，即皇后放置的位置，才能结合约束条件去做剪枝。
 * 使用三个集合columns、diagonalsX、diagonalsY
 * 分别记录每一列以及两个方向的每条斜线上是否有皇后。
 *
 */
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        //记录每一行皇后的列坐标Y
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonalsX = new HashSet<>();
        Set<Integer> diagonalsY = new HashSet<>();
        backtrack(solutions, queens, n, 0, columns, diagonalsX, diagonalsY);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonalsX, Set<Integer> diagonalsY) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonalsX.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonalsY.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonalsX.add(diagonal1);
                diagonalsY.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonalsX, diagonalsY);
                queens[row] = -1;
                columns.remove(i);
                diagonalsX.remove(diagonal1);
                diagonalsY.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
