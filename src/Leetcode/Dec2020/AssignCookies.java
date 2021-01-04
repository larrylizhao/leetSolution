package Leetcode.Dec2020;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  455. 分发饼干
 *  #贪心
 */
public class AssignCookies {
    /*
        g[i] 是第 i 个孩子的胃口
        s[j] 是第 j 块饼干的尺寸
        s[j] >= g[i] 第 i 个孩子得到满足

        满足尽可能多的孩子并输出最大值

        输入: g = [1,2,3], s = [1,1]
        输出: 1
        解释:
        你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
        虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
        所以你应该输出1。

        输入: g = [1,2], s = [1,2,3]
        输出: 2
     */
    /*
        尽可能进准的匹配g[i]和s[j]
        对两数组进行排序
        ？ 优先满足胃口大得还是有限派发大块饼干呢
     */
    public int findContentChildren(int[] g, int[] s) {
        g = Arrays.stream(g).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        s = Arrays.stream(s).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int res = 0;
        int lenChildren = g.length;
        for (int i = 0, j = 0;  j < s.length; ) {
            // 如果所有孩子都已经遍历完
            if(i > lenChildren - 1) {
                break;
            }
            // 当前饼干可满足该孩子, 继续查看下一块饼干与下一个孩子
            if(s[j] >= g[i]) {
                j++;
                i++;
                res++;
                continue;
            }

            // 当前饼干不可满足该孩子，则继续向后寻找可被满足的孩子，因为饼干是降序的
            if(s[j] < g[i]) {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] children = {10, 9, 8, 7};
        int[] candies = {5, 6, 7, 8};

        assignCookies.findContentChildren(children, candies);
    }
}
