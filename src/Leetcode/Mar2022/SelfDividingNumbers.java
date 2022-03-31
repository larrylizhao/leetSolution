package Leetcode.Mar2022;

import java.util.ArrayList;
import java.util.List;

/**
 *  728. 自除数
 */
public class SelfDividingNumbers {
    /*
     * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        while(left <= right) {
            if(isSelfDividingNumber(left)) {
                result.add(left);
            }
            left++;
        }
        return result;
    }

    private boolean isSelfDividingNumber(int num) {
        char[] numArray = Integer.toString(num).toCharArray();
        int len = numArray.length;
        // 非0的个位数一定是自除数
        if(num != 0 && len == 1) {
            return true;
        }
        // 检查每一位是否可以被整除
        for (char c : numArray) {
            int value = c - '0';
            if(value == 0) {
                return false;
            }
            if (num % (c - '0') == 0) {
                continue;
            }
            return false;
        }
        return true;
    }
}
