package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和III
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<> ();
        dfs(k, n, 1, res, path);
        return res;
    }

    private void dfs(int k, int target, int start, List<List<Integer>> res, List<Integer> path) {
        if(target == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        //剩余的最小可选数 * 可选次数 > 目标值，则没有必要再试
        if((k-path.size()) * start > target || target < 0 || path.size() == k) {
            return;
        }

        for(int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k, target - i, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
