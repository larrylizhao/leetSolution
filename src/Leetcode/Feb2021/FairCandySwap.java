package Leetcode.Feb2021;

import java.util.Arrays;

/**
 *  888. 公平的糖果棒交换
 *  #数组
 */
public class FairCandySwap {
    /*
        输入: A[] Alice所持有的糖果的大小 B[] Bob所持有的糖果的大小
        Alice和Bob要交换一个糖果，使得他们的糖果总量相同
        输出: ans[] ans[0]是Alice交换的糖果 ans[1]是Bob交换的糖果
     */

    /*
        计算Sum(A)和Sum(B)的差值diff，diff/2
        寻找A, B数组中差值为diff/2的数对
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int diff = sumA - sumB;
        if(diff > 0) {
            res = findSwap(A, B, diff);
        } else {
            res = findSwap(B, A, diff * -1);
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return  res;
    }

    // 从较小的数组低位开始遍历，与较大的数组高位进行比较，找到差值
    private int[] findSwap(int[] larger, int[] smaller, int diff) {
        int len = larger.length;
        for (int small : smaller) {
            for(int i = len - 1; i > -1; i--) {
                if(larger[i] - small == diff / 2) {
                    return new int[]{larger[i], small};
                }

                if(larger[i] - small < diff / 2) {
                    break;
                }
            }
        }
        return new int[]{};
    }
}
