package Leetcode.Jan2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  830. 较大分组的位置
 *  #字符串 #迭代
 */
public class PositionsOfLargeGroups {
    /*
        扫描字符串，存在长度大于2的相同子串就将下标加入res中
        slow指向子串的头部，fast遍历字符串判断是否和头部相同
        若相同，wordLen加以, fast继续向后遍历
        若不同，重置wordLen, 将slow指向fast
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        int len = chars.length;
        if(len < 3) {
            return res;
        }
        int wordLen = 1;
        for( int slow = 0, fast = 1; fast < len; fast++) {
            if(chars[slow] == chars[fast]) {
                wordLen++;
                continue;
            }

            if(wordLen > 2) {
                res.add(new ArrayList<>(Arrays.asList(slow, fast - 1)));
            }
            slow = fast;
            wordLen = 1;
        }
        return res;
    }
}
