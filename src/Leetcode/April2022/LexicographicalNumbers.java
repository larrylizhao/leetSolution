package Leetcode.April2022;

import java.util.ArrayList;
import java.util.List;

/**
 *  386. 字典序排数
 *  #
 */
public class LexicographicalNumbers {
    /*
        给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
        你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。

        输入：n = 13
        输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
     */
    public List<Integer> lexicalOrder(int n) {
        /*
            中序遍历10叉树
         */
        List<Integer> res = new ArrayList<>();
        int min = Math.min(10, n);
        for (int i = 1; i < min; i++) {
            res.add(i);
            if(10 * i < n + 1) {
                dfs(10 * i, res, n);
            }
        }
        return res;
    }

    private void dfs(int base, List<Integer> res, int limit) {
        for (int i = 0; i < 10; i++) {
            if(base + i <= limit) {
                res.add(base + i);
                if (10 * (base + i) < limit + 1) {
                    dfs(10 * (base + i), res, limit);
                }
            }
        }
    }
}
