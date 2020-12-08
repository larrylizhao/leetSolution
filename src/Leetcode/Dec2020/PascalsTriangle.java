package Leetcode.Dec2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  118. 杨辉三角
 *  #数组 #
 */
public class PascalsTriangle {
    /*
        给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
        在杨辉三角中，每个数是它左上方和右上方的数的和。

        示例:

        输入: 5
        输出:
        [
             [1],
            [1,1],
           [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
        ]
     */
    /*

     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows < 1) {
            return res;
        }
        res.add(Collections.singletonList(1));
        if(numRows == 1) {
            return res;
        }
        res.add(Arrays.asList(1,1));
        if(numRows == 2) {
            return res;
        }
        for(int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> lastRow = res.get(i - 1);
            for(int j = 0; j < lastRow.size() - 1; j++) {
                int elm = lastRow.get(j) + lastRow.get(j + 1);
                row.add(elm);
            }
            row.add(1);
            res.add(row);
        }

        return res;
    }
}
