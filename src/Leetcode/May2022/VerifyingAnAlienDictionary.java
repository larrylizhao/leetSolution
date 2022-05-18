package Leetcode.May2022;

import java.util.HashMap;
import java.util.Map;

/**
 *  953. 验证外星语词典
 */
public class VerifyingAnAlienDictionary {
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
}
