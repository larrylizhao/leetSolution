package Leetcode.April2022;

import java.util.ArrayList;
import java.util.List;

/**
 *  821. 字符的最短距离
 *  #字符串
 */
public class ShortestDistanceToACharacter {
    /*
        给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
        返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。

     */
    public int[] shortestToChar(String s, char c) {
        char[] sChar = s.toCharArray();
        int len = sChar.length;
        int[] res = new int[len];
        List<Integer> cIdx = new ArrayList<>();
        // 获取C字符的下标
        for (int i = 0; i < len; i++) {
            if (sChar[i] == c) {
                cIdx.add(i);
            }
        }

        int leftC = -1;
        // 用于遍历cIdx
        int cIndex = 0;
        int rightC = cIdx.get(cIndex);
        for (int i = 0; i < len; i++) {
            if(i < rightC) {
                res[i] = leftC == -1 ? rightC - i : Math.min(i - leftC, rightC - i);
            } else if(i == rightC) {
                res[i] = 0;
            } else {
                leftC = rightC;
                rightC = cIndex == cIdx.size() - 1 ? Integer.MAX_VALUE : cIdx.get(++cIndex);
                res[i] = Math.min(i - leftC, rightC - i);
            }
        }
        return res;
    }
}
