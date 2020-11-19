package Leetcode.Nov2020;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  283. 移动零
 *  #数组
 */
public class MoveZeroes {
    /*
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        Queue<Integer> nonZeros = new LinkedList<>();
        int i = 0;
        int len = nums.length;
        while (i < len) {
            if(nums[i] != 0) {
                nonZeros.offer(nums[i]);
            }
            i++;
        }
        int queueLen = nonZeros.size();
        while(queueLen < len) {
            nonZeros.offer(0);
            queueLen++;
        }

        for (int i1 = 0; i1 < nums.length; i1++) {
            if(!nonZeros.isEmpty()) {
                nums[i1] = nonZeros.poll();
            }
        }
    }
}
