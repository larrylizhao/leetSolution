package Leetcode.Dec2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  49. 字母异位词分组
 *  #字符串 #排序 #数组
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
    /*
        关键是寻找哈希表的键, 将相同键的字符串放在一组
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

    public List<List<String>> groupAnagrams_count(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            // 天然已经是排好序的了
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams_stream(String[] strs) {
        // Get stream from array string
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }

    // str -> intstream -> sort -> collect by StringBuilder
    public List<List<String>> groupAnagrams_stream_2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())).values());
    }

    public List<List<String>> groupAnagrams_stream_3(String[] strs) {
        // str -> split -> stream -> sort -> join
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(
                str -> Stream.of(str.split("")).sorted().collect(Collectors.joining()))).values());
    }

    /*
        算术基本定理: 任何一个大于1的自然数N，如果N不为质数，那么N可以分解成有限个质数的乘积, 且该分解唯一
        [a, z]Unicode编码 - 97=[0, 25] 对应26个质数。每字母代表质数的乘积表示字符串
        乘法交换律忽略字母顺序。算术基本定理保证不同质数 或 相同质数不同个数，乘积唯一
     */
    public List<List<String>> groupAnagrams_prime(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Integer, List<String>> map = new HashMap<>();

    }
        // str -> split -> stream -> sort -> join
    var groupAnagrams = function(strs) {
        var h = new Map, prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
        for(var i = 0; i < strs.length; i++) {
            for(var j = 0, sum = 1; j < strs[i].length; j++)
                sum *= prime[strs[i].charCodeAt(j) - 97]
            h.has(sum) ? h.get(sum).push(strs[i]) : h.set(sum, [strs[i]])
        }
        return Array.from(h.values())
    };

}
