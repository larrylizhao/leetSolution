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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> res) {
        if(target < 0) {
            return;
        }

        if( target == 0 ) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int candidate : candidates) {
            path.add(candidate);
            dfs(candidates, target - candidate, path, res);
            path.remove(path.size() - 1);
        }
    }
}
