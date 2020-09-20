package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * #回溯
 */
public class Subsets {
    /*
    输入: nums = [1,2,3]
    输出:
    [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
    ]
    说明：解集不能包含重复的子集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), 0, false);
        return res;
    }

    // 选或者不选两种可能，遍历所有可能性
    // 不选并且已添加的subset不要重复加入res中即可去重
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> subset, int start, boolean added) {
        if(!added) {
            res.add(new ArrayList<>(subset));
        }

        if(start == nums.length) {
            return;
        }

        dfs(nums, res, subset, start + 1, res.contains(subset));

        subset.add(nums[start]);
        dfs(nums, res, subset, start + 1, false);
        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        List<List<Integer>> res = subsets.subsets(nums);
        System.out.println(res);
    }
}
