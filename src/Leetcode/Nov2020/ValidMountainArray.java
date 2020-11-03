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
    public boolean validMountainArray(int[] A) {
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
