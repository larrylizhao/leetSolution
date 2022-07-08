package Leetcode.Jul2022;

import java.util.Comparator;
import java.util.List;

/**
 *  648. 单词替换
 *  #字符串
 */
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < words.length; i++) {
            for (String dic : dictionary) {
                if (words[i].startsWith(dic)) {
                    words[i] = dic;
                }
            }
        }
        return String.join(" ", words);
    }
}
