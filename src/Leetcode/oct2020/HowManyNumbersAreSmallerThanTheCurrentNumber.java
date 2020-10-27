package Leetcode.oct2020;

/**
 * 1365. 有多少小于当前数字的数字
 * #数组
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    /*
        给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
        以数组形式返回答案。

        输入：nums = [8,1,2,2,3]
        输出：[4,0,1,1,3]
        解释：
        对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
        对于 nums[1]=1 不存在比它小的数字。
        对于 nums[2]=2 存在一个比它小的数字：（1）。
        对于 nums[3]=2 存在一个比它小的数字：（1）。
        对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
     */

    /*
        遍历数组并将数组元素两两比较
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    res[i]++;
                }
                if (nums[i] < nums[j]) {
                    res[j]++;
                }
            }
        }
        return res;
    }
}
