package Leetcode;

/**
 * 557. 反转字符串中的单词III
 */
public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty()) {
            return "";
        }

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(reverseWord(str)).append(" ");
        }
        return sb.toString().trim();
    }

    private String reverseWord(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }
}
