package Leetcode.April2022;

import java.util.HashSet;
import java.util.Set;

/*
    804. 唯一摩尔斯密码词
    #数组 #HashSet
 */
public class UniqueMorseCodeWords {
    /*
        给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
        例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
        对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。

        输入: words = ["gin", "zen", "gig", "msg"]
        输出: 2
        解释:
        各单词翻译如下:
        "gin" -> "--...-."
        "zen" -> "--...-."
        "gig" -> "--...--."
        "msg" -> "--...--."
        共有 2 种不同翻译, "--...-." 和 "--...--.".
     */
    public int uniqueMorseRepresentations(String[] words) {
        final String[] Morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder sb = new StringBuilder();
        Set<String> translated = new HashSet<>();
        for (String word : words) {
            for (char character : word.toCharArray()) {
                sb.append(Morse[character - 'a']);
            }
            translated.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return translated.size();
    }
}
