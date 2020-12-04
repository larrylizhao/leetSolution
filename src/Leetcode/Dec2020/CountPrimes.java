package Leetcode.Dec2020;

/**
 *  204. 计数质数
 */
public class CountPrimes {
    /*
        统计所有小于非负整数 n 的质数的数量。
        输入：n = 10
        输出：4
        解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

        输入：n = 0
        输出：0
     */
    public int countPrimes(int n) {
        int count = 0;
        if( n == 0 || n == 1) {
            return 0;
        }

        int i = n;
        while(i > 1) {
            if(isPrime(i)) {
                count++;
            }
            i--;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if(n == 2) {
            return false;
        }
        int i = n - 1;
        while(i > 1) {
            if(n % i == 0) {
                return false;
            }
            i--;
        }
        return true;
    }
}
