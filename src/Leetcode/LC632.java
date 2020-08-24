package Leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 632. 最小区间
 * https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/
 */
public class LC632 {
    public static void main(String[] args) {
        LC632 lc623 = new LC632();
//        int[] smallestRange = lc623.smallestRange();
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(index -> nums.get(index).get(next[index])));
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIndex = priorityQueue.poll();
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            priorityQueue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{ rangeLeft, rangeRight };
    }
}
    /*
     *   LC632. 最小区间
//     */
//    public int[] smallestRange(List<List<Integer>> nums) {
//        if (nums.size() == 1) {
//            return new int[] {nums.stream().}
//        }
//
//        int maxMin = nums.stream().map(num -> num.stream().min(Integer::compare)).filter(Optional::isPresent).max(Comparator.naturalOrder()).orElse(Integer.MAX_VALUE);
//        int minMax = nums.stream().map(num -> num.stream().mapToInt(v -> v).max()).mapToInt(OptionalInt::getAsInt).min();
//
//        return new int[0];
//    }