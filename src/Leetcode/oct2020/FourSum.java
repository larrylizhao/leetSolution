package Leetcode.oct2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * #回溯
 */
public class FourSum {
    /*
        给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

        满足要求的四元组集合为：
        [
          [-1,  0, 0, 1],
          [-2, -1, 1, 2],
          [-2,  0, 0, 2]
        ]

        答案中不可以包含重复的四元组。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> num, int idx) {
        int chosen = num.size();
        int arrSize = nums.length;
        if(chosen == 4) {
            if(target == 0) {
                res.add(new ArrayList<>(num));
            }
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            // 避免同层递归重复使用相同元素
            if(i > idx && nums[i] == nums[i-1]) {
                continue;
            }

            // 减枝
            // 已选择个数加上剩余可选择个数不足四个
            if(arrSize - i < 4 - chosen) {
                break;
            }

            // 当前数字 + (n - 1) * 排序后数组中当前数字的下一个数字 > target, 当前数字及后续数字都不行, 直接剪掉, 递归返回
            if(i < arrSize - 1 && nums[i] + nums[i+1] * (4 - chosen - 1) > target) {
                break;
            }

            // 当前数字 + (n - 1) * 排序后数组最后一个数字 < target, 当前数字不行，进入下一次循环
            if(nums[i] + nums[arrSize - 1] * (4 - chosen - 1) < target) {
                continue;
            }

            num.add(nums[i]);
            dfs(nums, target - nums[i], res, num, i + 1);
            num.remove(num.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        FourSum fourSum = new FourSum();
        fourSum.fourSum(nums, target);
    }
}
