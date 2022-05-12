package Leetcode.May2022;

/**
 *  944. 删列造序
 *  #字符串
 */
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        if(strs.length == 0) return 0;
        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if(strs[j].charAt(i) - strs[j + 1].charAt(i) > 0) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
