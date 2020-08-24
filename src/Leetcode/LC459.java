package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 459. 重复的子字符串
 */
public class LC459 {
    public static void main(String[] args) {
        LC459 lc459 = new LC459();
        String test = "bb";
        lc459.repeatedSubstringPattern(test);
    }
    public boolean repeatedSubstringPattern(String s) {
        //首先找到长度的公约数,然后从大到小进行尝试
        int length = s.length();
        List<Integer> mods = mods(length);
        for (Integer mod : mods) {
            boolean match = true;
            for (int i = 0; i < length - 2 * mod + 1; i+=mod) {
                if (!s.substring(i, i + mod).equals(s.substring(i + mod, i + 2 * mod))) {
                    match = false;
                    break;
                }
            }
            if(match) {
                return true;
            }
        }
        return false;
    }

    List<Integer> mods(int length) {
        //小于4的是负数或者都只能被1和本身整除
        List<Integer> list = new ArrayList<> ();
        list.add(1);
        if(length < 4) {
            return list;
        }
        int half = length / 2;
        for(int i=2; i<=half; i++) {
            if(length % i == 0) {
                list.add(i);
                if(i != length / i) {
                    list.add(length / i);
                }
            }
        }
        return list;
    }
}
