package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * #回溯
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum.combinationSum(candidates, target);
        System.out.println(res);
    }

    /*
    输入：candidates = [2,3,5], target = 8,
    所求解集为：
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]

    candidates是无重复数组
    每个数字可以用无限次
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> res) {
        // 剪枝回溯
        if(target < 0) {
            return;
        }

        // 获得一组可行解
        if( target == 0 ) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历所有选择
        for (int candidate : candidates) {
            path.add(candidate);
            // 当前的选择决定了下一个选择是怎么展开的
            dfs(candidates, target - candidate, path, res);
            path.remove(path.size() - 1);
        }
    }
}
