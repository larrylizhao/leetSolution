package Leetcode.Jul2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int absDiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i+1] - arr[i];
            if(diff < absDiff) {
                absDiff = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i+1]));
            } else if( diff == absDiff) {
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return res;
    }
}
