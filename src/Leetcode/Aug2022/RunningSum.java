package Leetcode.Aug2022;

/**
 *  1480. 一维数组的动态和
 */
public class RunningSum {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = i == 0 ? nums[i] : result[i-1] + nums[i];
        }
        return result;
    }
}
