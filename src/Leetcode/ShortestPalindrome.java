package Leetcode;

import Palindrome.Manacher;

/**
 * 214. 最短回文串
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        System.out.println(shortestPalindrome.shortestPalindrome("aacecaaa"));
    }

    public String shortestPalindrome(String s) {
        Manacher manacher = new Manacher(s);
        int len = s.length();
        for (int i = len - 1; i > -1 ; i--) {
            if(manacher.isPalindrome(0, i)) {
                StringBuilder sb = new StringBuilder(s.substring(i + 1));
                sb.reverse().append(s);
                return sb.toString();
            }
        }
        return "";
    }

    //从定义可知，一个长为 n 的字符串 S 是回文串的充要条件是，对于 i ∈ [0, n-1]，都有S[i]与S[n-1-i] 相等。也就是S的前一半和后一半是"镜像"的。
    boolean is_palindrome(String s) {
        char[] chars = s.toCharArray();
        // 只枚举前一半就 OK 了
        for(int i = 0, n = chars.length; i < n/2; i++) {
            if(chars[i] != chars[n-i-1]) {
                return false; // 只要有一个位置不相等，那就肯定不是回文咯
            }
        }
        return true; // 所有位置都符合要求，那当然是回文咯
    }
}
