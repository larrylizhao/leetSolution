package Leetcode.oct2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. 划分字母区间
 * #字符串 #双指针
 */
public class PartitionLabels {
    /*
        输入：S = "ababcbacadefegdehijhklij"
        输出：[9,7,8]
        解释：
        划分结果为 "ababcbaca", "defegde", "hijhklij"。
        每个字母最多出现在一个片段中。
        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     */
    /*
        思路一: 统计母串中字符出现的次数。然后再遍历一次S，若所有字符的统计
        次数无变化或为0时，立刻分裂字串！
     */
    public List<Integer> partitionLabels(String S) {
        // 记录已扫描字符串中所有字符中的最远位置
        int maxPosition = -1;
        List<Integer> res = new ArrayList<>();
        int start = 0;

        // 扫描字符串, 记录每个字符的最远位置
        Map<Character, Integer> charMaxPosition = new HashMap<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charMaxPosition.put(chars[i], i);
        }

        // 扫描字符串，并维护已扫描字符串的最远位置
        for (int i = 0; i < chars.length; i++) {
            // 扫描过程中发现了新的最远位置则更新maxPosition
            maxPosition = Math.max(maxPosition, charMaxPosition.get(chars[i]));
            // 当扫描到这个位置且并没有发现新的最远位置时，可以做切割
            if(maxPosition == i) {
                res.add(maxPosition - start + 1);
                start = maxPosition + 1;
            }
        }
        return res;
    }

    /*
        1. 创建一个map，并遍历一遍 S 找到每个字符在该字符串中的最终位置（不用内置的index函数，因为那样比较费时）
        2. 再次遍历 S ，创建窗口，窗口右界为当前未遍历过字符串的第一个字符的最后一次出现的位置
        3. 若找到窗口内的字符有最后位置大于窗口右界的，则将窗口的大小扩充到此位置
        4. 若窗口内内容遍历完成，则输出窗口长度，并移动窗口到新字符串
        时间复杂度为O(n)
     */
}
