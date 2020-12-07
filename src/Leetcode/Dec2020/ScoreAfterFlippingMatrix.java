package Leetcode.Dec2020;

/**
 *  861. 翻转矩阵后的得分
 *  #贪心
 */
public class ScoreAfterFlippingMatrix {
    /*
        有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
        移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
        在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
        返回尽可能高的分数。

        输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
        输出：39
        解释：
        转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
        0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
     */

    /*
        贪心:
        首先翻转行，确保最高位是1. 0b1000 > 0b0111
        然后翻转列，确保当前列中1的个数多过0的个数
        从而达到相加的和最大

        实际编写代码时，我们无需修改原矩阵，而是可以计算每一列对总分数的「贡献」，从而直接计算出最高的分数。假设矩阵共有 m 行 n 列，计算方法如下：
        对于最左边的列而言，由于最优情况下，它们的取值都为 1，因此每个元素对分数的贡献都为 2^{n-1}, 总贡献为 m * 2^{n-1}。
        对于第 j 列（j>0)，此处规定最左边的列是第 0 列而言，我们统计这一列 0/1 的数量，令其中的最大值为 k，则 k 是列翻转后的 1 的数量，该列的总贡献为 k * 2^{n-j-1}。需要注意的是，在统计 0,1 的数量的时候，要考虑最初进行的行反转。
     */
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        boolean[] flipped = new boolean[row];

        // 首先遍历每行，把第一个元素置为1
        for(int i = 0; i < row; i++) {
            if(A[i][0] == 0) {
                flipped[i] = true;
            }

        }

        // 1 << col - 1 表示 2 的 col-1 次方
        int count = row * (1 << (col - 1));

        // 遍历每一列，统计0/1个数，较多的那个当作1的个数
        for(int j = 1; j < col; j++) {
            // 计算每一列中0的个数
            int count_1 = 0;
            for(int i = 0; i < row; i++) {
                if((!flipped[i] && A[i][j] == 1) || (flipped[i] && A[i][j] == 0)) {
                    count_1++;
                }
            }
            // 取较多的个数当作1的个数
            count_1 = Math.max(count_1, row - count_1);
            count += count_1 * (1 << (col - j - 1));
        }
        // 2的1次方
        System.out.println(1 << 1);
        return count;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix scoreAfterFlippingMatrix = new ScoreAfterFlippingMatrix();
        int[][] array = new int[][] {{0,1}, {0,0}};
        scoreAfterFlippingMatrix.matrixScore(array);
    }
}
