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
        //dfs(nums, res, new ArrayList<>(), 0, false);
        preOrder(nums, 0, new ArrayList<>(), res);
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

        //  左子树是不选
        dfs(nums, res, subset, start + 1, res.contains(subset));

        // 右子树是选

        // 作出选择
        subset.add(nums[start]);
        // 进行递归
        dfs(nums, res, subset, start + 1, false);
        // 递归弹出后，要进行回溯
        subset.remove(subset.size() - 1);
    }

    // 遍历生成路径
    public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        // 到了新的状态，记录新的路径，要重新拷贝一份
        subset = new ArrayList<>(subset);

        // 这里
        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
    }

    // 位运算
    public List<List<Integer>> subsets_binary(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            subset.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(subset));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        List<List<Integer>> res = subsets.subsets(nums);
        System.out.println(res);
    }
}
