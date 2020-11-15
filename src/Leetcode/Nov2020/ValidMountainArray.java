package Leetcode.Nov2020;

/**
 * 941. 有效的山脉数组
 * #数组 #双指针
 */
public class ValidMountainArray {
    /*
        给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
        示例 1：
        输入：[2,1]
        输出：false

        示例 2：
        输入：[3,5,5]
        输出：false

        示例 3：
        输入：[0,3,2,1]
        输出：true
     */
    // 双指针: 一头一尾
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int i = 0;
        int j = len - 1;
        if(len < 3) {
            return false;
        }

        // 左指针可以爬高就右移
        while(i < len - 1 && A[i] < A[i + 1]) {
            i++;
        }
        // 右指针可以爬高就左移
        while(j > 0 && A[j] < A[j - 1]) {
            j--;
        }

        // 判断左右山峰是否重合而且
        return i == j && i != 0 && j != len - 1;
    }

    // 双指针: 一前一后
    public boolean validMountainArray_fastslow(int[] A) {
        int i = 0;
        int j = 1;
        int len = A.length;
        //  数组长度小于3则一定不是山脉
        if(len < 3) {
            return false;
        }
        boolean increment = true;
        while(j < len) {
            // 有相同元素, 一定不是山脉
            if(A[i] == A[j]) {
                return false;
            }

            // 初始情况为递增
            if(A[i] < A[j] && increment) {
                i++;
                j++;
                continue;
            } else {
                // 如果一开始就递减, 则一定不是山脉
                if(i == 0) {
                    return false;
                }
                // 发生递减改变flag的值
                increment = false;
            }

            // 递减之后出现递增, 则一定不是山脉
            if(A[i] < A[j]) {
                return false;
            }
            i++;
            j++;
        }

        return !increment;
    }
}
