package Leetcode.April2022;

import java.util.Arrays;
import java.util.List;

/**
 *  824. 山羊拉丁文
 *  #字符串
 */
public class GoatLatin {
    /*

     */
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder append = new StringBuilder();
        String goat = "ma";
        for (int i = 0; i < words.length; i++) {
            append.append("a");
            StringBuilder sb = new StringBuilder();
            if (vowel.contains(words[i].charAt(0))) {
                sb.append(words[i])
                        .append(goat)
                        .append(append);
            } else {
                sb.append(words[i].substring(1, words[i].length()))
                        .append(words[i].charAt(0))
                        .append(goat)
                        .append(append);
            }
            words[i] = sb.toString();
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        GoatLatin goatLatin = new GoatLatin();
        goatLatin.toGoatLatin("I speak Goat Latin");
    }
}
