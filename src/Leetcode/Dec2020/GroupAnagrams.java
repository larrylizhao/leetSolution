package Leetcode.Dec2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  49. 字母异位词分组
 *  #字符串
 */
public class GroupAnagrams {
    /*
        给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

        示例:
        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 对数组排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            // 排序后的字符串作为key, 如果字符串是异位词，排序后的字符串相同
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
