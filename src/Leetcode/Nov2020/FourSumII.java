package Leetcode.Nov2020;

import java.util.HashMap;
import java.util.Map;

/**
 *  454. 四数相加 II
 *  #哈希表 #二分查找
 */
public class FourSumII {
    /*
        给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
        为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。

        输入:
        A = [ 1, 2]
        B = [-2,-1]
        C = [-1, 2]
        D = [ 0, 2]
        输出:
        2

        解释:
        两个元组如下:
        1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
        2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */
    /*
        将数组对半分，统计两边的和并用哈希记录。检查有几组互为相反的数
        复杂度为n^2
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 将A[i] + B[j]的值加入到哈希，key为值，value为出现次数
        int n = A.length;
        Map<Integer, Integer> sumAB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                int value = sumAB.getOrDefault(sum, 0);
                value++;
                sumAB.put(sum, value);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
            }
        }
    }
}
