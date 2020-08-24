package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC93. 复原IP地址
 */
public class LC93 {

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return ans;
    }


    /**
     * dfs递归遍历所有可能组合，通过辅助参数segId记录当前正在遍历第几段IP。
     * 通过segStart标记剩余字串的起始位置，从而对剩余字串进行遍历
     * @param s String 需要遍历的字串
     * @param segId int {0,3} 代表正在遍历第几段IP,一共有4段
     * @param segStart int 剩余字串的起始位置
     */
    public void dfs(String s, int segId, int segStart) {
        // 退出条件1：找到了 4 段 IP 地址
        if (segId == SEG_COUNT) {
            //如果此时刚好遍历完数组，即找到了一组答案，将其添加到答案列表中
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            //否则说明不符合条件，结束回溯
            return;
        }

        // 退出条件2：遍历完了字符串，但是还没有找到4段IP地址，提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);  //通过辅助参数进行接力，对剩余的IP段和字串进行枚举遍历
            } else {
                //如果枚举的IP段大于255，则立即停止枚举，并进行回溯
                //谁调用的它，break后就会回退到哪里
                //即代表此路不通，不需要再向下进行遍历或递归，从这个位置直接结束接下来的所有枚举
                break;
            }
        }
    }
}
