package Leetcode.May2022;

/**
 *   一次编辑
 *   #双指针 #字符串
 */
public class OneAwayIcci {
    /*
        只需一次编辑就可以使得两个字符串相等
     */
    public boolean oneEditAway(String first, String second) {
        // 本身就相等
        if(first.equals(second)) return true;
        int len1 = first.length();
        int len2 = second.length();
        char[] firstc = first.toCharArray();
        char[] secondc = second.toCharArray();
        // 字符串长度差大于1
        if(Math.abs(len1 - len2) > 1) {
            return false;
        } else if (len1 == len2) {  // 长度相同
            int diff = 0;
            for (int i = 0; i < len1; i++) {
                if(diff > 1) {
                    return false;
                }
                if(firstc[i] != secondc[i]) {
                    diff++;
                }
            }
            return diff < 2;
        } else {                    // 长度相差1
            int diff = 0;
            int i = 0;
            int j = 0;
            // first 或 second 一个是空串一个长度为一
            if(len1 + len2 < 2) return true;
            // 若首字母不同，因为长度差为1，所以截取首字母后字符串应相同
            if(firstc[0] != secondc[0]) {
                return first.substring(1).equals(second) || second.substring(1).equals(first);
            }
            // 若首字母相同
            while(i < len1 && j < len2) {
                if(diff > 1) {
                    return false;
                }
                if(firstc[i] != secondc[j]) {
                    if(len1 > len2) i++;
                    if(len2 > len1) j++;
                    diff++;
                    continue;
                }
                i++;
                j++;
            }
            return diff < 2;
        }
    }
}
