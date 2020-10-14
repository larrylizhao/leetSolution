package Leetcode.oct2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. 查找常用字符
 * #字符串 #哈希表
 */
public class FindCommonCharacters {
    /*
        给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
        输入：["bella","label","roller"]
        输出：["e","l","l"]

        输入：["cool","lock","cook"]
        输出：["c","o"]
     */
    // 统计每个string中character出现的次数
    Map<String, Map<Character, Integer>> statistic = new HashMap<>();

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        // 统计符合条件的character次数，比如["e","l","l"]中的两个l
        Map<Character, Integer> charCount = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        // 找到最短的字符串，以便遍历其中字符
        for (String s : A) {
            if(s.length() < minLen) {
                minLen = s.length();
                minStr = s;
            }
        }

        char[] chars = minStr.toCharArray();
        // 遍历A数组中最短字符串中的每一个字符
        for (char aChar : chars) {
            int count = 0;
            // 统计字符串出现过的次数，以处理同一字符串出现多次的情况
            int freq = charCount.getOrDefault(aChar, 0);
            // 检查A数组中string是否包含该字符，以及字符的个数是否符合条件
            for (String s : A) {
                if(s.indexOf(aChar) < 0) {
                    break;
                }
                // 统计每个string中不同字符的出现次数
                int occurrence = getOccurrence(s, aChar);
                // 字符出现次数要符合条件才可进行计数
                if(occurrence >= freq + 1) {
                    count++;
                }
            }
            // 条件判断: 字符出现次数和数组长度相等证明每个string都包含该字符
            if(count == A.length) {
                charCount.put(aChar, freq + 1);
            }
        }
        // 将Map中的统计数据写入res答案中
        for(Character c : charCount.keySet()) {
            int count = charCount.get(c);
            while(count > 0) {
                res.add(String.valueOf(c));
                count--;
            }
        }
        return res;
    }

    private int getOccurrence(String str, char achar) {
        Map<Character, Integer> charCount = new HashMap<>();
        if(!statistic.containsKey(str)) {
            char[] strChar = str.toCharArray();
            for (char c : strChar) {
                int freq = charCount.getOrDefault(c, 0);
                charCount.put(c, freq + 1);
            }
            statistic.put(str, charCount);
        }
        charCount = statistic.get(str);
        return charCount.getOrDefault(achar, 0);
    }

    public static void main(String[] args) {
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        String[] test = {"cool","lock","cook"};
        List<String> res = findCommonCharacters.commonChars(test);
        System.out.println(res);
    }
}
