package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和II
 * #回溯
 * 1. 要对组合进行去重: 排序去重，for 循环枚举出选项时，忽略掉同一层重复的选项
 * 比如[1,2,2,2,5]中，选了第一个 2，变成 [1,2]，第一个 2 的下一选项也是 2，跳过它，因为选它，就还是 [1,2]。
 * 2. 不可重复使用candidates中的数: i指针遍历candidates, 每次递归的时候i+1
 */
public class CombinationSum2 {
    /*
        输入: candidates = [10,1,2,7,6,1,5], target = 8,
        所求解集为:
        [
          [1, 7],
          [1, 2, 5],
          [2, 6],
          [1, 1, 6]
        ]
        注意：
            candidates 中的每个数字在每个组合中只能使用一次
            解集不能包含重复的组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if(target < 0 || idx == candidates.length) {
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            //  确保同层递归不会选择相同元素，达到去重的效果
            if(i > idx && candidates[i - 1] == candidates[i]){
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    /*
        不用for循环的解法无法实现跳过同层
     */
    private void dfs_binary(int[] candidates, int target, int start, int idx, List<Integer> path, List<List<Integer>> res, boolean chosen) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if((idx > start && candidates[idx - 1] == candidates[idx] && !chosen)) {
            idx++;
        }

        if(target < 0 || idx == candidates.length) {
            return;
        }

        if(idx + 1 < candidates.length && candidates[idx] != candidates[idx + 1]) {
            start = idx + 1;
        }

        //对于数组中的每个数，都有两种选择，选或不选
        dfs_binary(candidates, target, start, idx + 1, path, res, false);

        path.add(candidates[idx]);
        dfs_binary(candidates, target - candidates[idx], start, idx + 1, path, res, true);
        // 回溯点: 在return之前需要撤销之前的选择
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
//        int[] candidates = {1, 1};
        int target = 8;
        List<List<Integer>> ans = combinationSum2.combinationSum2(candidates, target);
        System.out.println(ans);
    }
}
