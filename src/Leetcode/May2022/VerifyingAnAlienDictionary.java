package Leetcode.May2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  953. 验证外星语词典
 */
public class VerifyingAnAlienDictionary {
    // 根据题意模拟 - 1
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length < 2) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(char c : order.toCharArray()) {
            map.put(c, i++);
        }

        for (int j = 0; j < words.length - 1; j++) {
            char[] wordOne = words[j].toCharArray();
            char[] wordTwo = words[j+1].toCharArray();
            int k = 0;
            if(words[j].length() > words[j+1].length() && words[j].contains(words[j+1])) {
                return false;
            }
            while(k < wordOne.length && k < wordTwo.length) {
                if(map.get(wordOne[k]) > map.get(wordTwo[k])) {
                    return false;
                }
                if(map.get(wordOne[k]) < map.get(wordTwo[k])) {
                    break;
                }
                k++;
            }
        }
        return true;
    }

    // 根据题意模拟 - 2
    int[] ord = new int[26];
    public boolean isAlienSorted_2(String[] words, String order) {
        for (int i = 0; i < 26; i++) ord[order.charAt(i) - 'a'] = i;
        int n = words.length;
        for (int i = 1; i < n; i++) {
            if (check(words[i - 1], words[i]) > 0) return false;
        }
        return true;
    }
    int check(String a, String b) {
        int n = a.length(), m = b.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            int c1 = a.charAt(i) - 'a', c2 = b.charAt(j) - 'a';
            if (c1 != c2) return ord[c1] - ord[c2];
            i++; j++;
        }
        // 前面的单词长过后面的
        if (i < n) return 1;
        // i == n == j && j < m 说明后面的单词更长
        if (j < m) return -1;
        return 0;
    }

    // 自定义排序
    public boolean isAlienSorted_sort(String[] words, String order) {
        int[] ord = new int[26];
        for (int i = 0; i < 26; i++) ord[order.charAt(i) - 'a'] = i;
        String[] clone = words.clone();
        Arrays.sort(clone, (a, b)->{
            int n = a.length(), m = b.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                int c1 = a.charAt(i) - 'a', c2 = b.charAt(j) - 'a';
                if (c1 != c2) return ord[c1] - ord[c2];
                i++; j++;
            }
            if (i < n) return 1;
            if (j < m) return -1;
            return 0;
        });
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (!clone[i].equals(words[i])) return false;
        }
        return true;
    }
}
