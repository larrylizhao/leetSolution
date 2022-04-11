package Leetcode.April2022;

/**
 *  357. 统计各位数字都不同的数字个数
 */
public class CountNumbersWithUniqueDigits {
    /*
        给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n 。
        输入：n = 2
        输出：91
        解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
     */
    public int countNumbersWithUniqueDigits(int n) {
        if( n == 0 ) return 1;
        // n == 1时，一共有10种选择
        int result = 10;
        // 对于n == 2时，首位不可能是0所以有9种选择
        int lastChoice = 9;
        for(int i = 2; i <= n; i++) {
            // 每往后递推一位选择就少一个
            int currentChoice = lastChoice * (10 - i + 1);
            // 每一位的结果是上一位加上当前的选择数
            result += currentChoice;
            lastChoice = currentChoice;
        }
        return result;
    }
}
