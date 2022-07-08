package Leetcode.Jul2022;

/**
 *  1217. 玩筹码
 */
public class MoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int i : position) {
            if( i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
