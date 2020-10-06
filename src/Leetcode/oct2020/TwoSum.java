package Leetcode.oct2020;

/**
 * 1. 两数之和
 *
 */
public class TwoSum {
    /*
        示例:
        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]

        1. 数组中同一个元素不能使用两遍
        2. 每组输入只有一个答案
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(arr, target);
    }
}
