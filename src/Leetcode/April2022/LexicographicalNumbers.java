package Leetcode.April2022;

import java.util.ArrayList;
import java.util.List;

/**
 *  386. 字典序排数
 *  #DFS #中序遍历
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
            // 通过 i * 10 进入 i 的子节点，子节点未超过n
            if(10 * i <= n) {
                // 遍历子节点
                dfs(10 * i, res, n);
            }
        }
        return res;
    }

    private void dfs(int base, List<Integer> res, int limit) {
        for (int i = 0; i < 10; i++) {
            int current = base + i;
            if(current <= limit) {
                res.add(current);
                // 通过current * 10进入current的子节点
                if (10 * current <= limit) {
                    dfs(10 * current, res, limit);
                }
            }
        }
    }
}
