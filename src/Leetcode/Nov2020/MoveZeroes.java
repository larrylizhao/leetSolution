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

    // 用队列储存所有非0元素并补齐0，最后输出到数组
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

//========================================================================================//
    // 双指针 - 慢指针维护0与非0边界，快指针向后查找非0元素并与边界上的0进行交换
    public void moveZeroes_pointer(int[] nums) {
        int slow = 0;
        int len = nums.length;
        // 找到第一个非0元素
        while(slow < len) {
            if(nums[slow] == 0) {
                break;
            }
            slow++;
        }
        // slow是0与非0的边界
        int fast = slow + 1;
        while(fast < len) {
            // fast遇到非0, 则与边界处的0进行交换
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                // 更新边界坐标
                slow++;
            }
            // 如果是0, fast直接向前移动
            fast++;
        }
    }


    public void moveZeroes_quicksort(int[] nums) {
        if(nums==null) {
            return;
        }
        // 初始状态i和j重叠
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            // 当遇到0时, j指向0,i++继续向后寻找非0元素并与j指向的0交换
            // nums[j++]交换后j右移 可以与i再次重叠也可以指向下一个非0元素
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes_quicksort(new int[]{1,2,0,3,4,0,0,5,0});
    }
}
