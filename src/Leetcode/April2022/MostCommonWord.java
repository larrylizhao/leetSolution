package Leetcode.April2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 *  819. 最常见的单词
 *  #字符串 #正则
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 将非字符全部转为空格，方便split统一处理
        String regex = Arrays.stream(banned).reduce("[^\\w]+|", (acc, ele) -> {return acc+ele+"|";});
        regex = regex.substring(0, regex.length() - 1);
        // 去除头尾空格并split\s+, 此时字符串只有空格和字符
        String[] filtered = paragraph.toLowerCase().replaceAll(regex, " ").trim().split("\\s+");

        Map<String, Integer> statistic = new HashMap<>();
        for(String word : filtered) {
            statistic.put(word, statistic.getOrDefault(word, 0) + 1);
        }
        int max = 0;
        String maxWord = "";
        for(Map.Entry<String, Integer> entry : statistic.entrySet()) {
            int count = entry.getValue();
            if(count > max) {
                max = count;
                maxWord = entry.getKey();
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        String test = "Bob. hIt, baLl";
        String[] testBan = {"bob", "hit"};
        MostCommonWord  mostCommonWord = new MostCommonWord();
        mostCommonWord.mostCommonWord(test, testBan);
    }
}
