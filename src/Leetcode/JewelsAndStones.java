package Leetcode;

/**
 * 771. 宝石与石头
 */
public class JewelsAndStones {
    /*
        J中字符在S中的出现次数
        输入: J = "aA", S = "aAAbbbb"
        输出: 3
     */
    public int numJewelsInStones(String J, String S) {
        char[] stones = S.toCharArray();
        int count = 0;
        for (char stone : stones) {
            if(J.indexOf(stone) > -1) {
                count++;
            }
        }
        return count;
    }
}
