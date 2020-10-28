package Leetcode.oct2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 * #数组
 */
public class UniqueNumberOfOccurrences {
    /*
        给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
        如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

        输入：arr = [1,2,2,1,1,3]
        输出：true
        解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        // 统计数字出现的次数
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        // 将出现次数加入set中
        Set<Integer> numCount = new HashSet<>(count.values());
        // 判断map和set的大小是否相等
        return numCount.size() == count.size();
    }
}
