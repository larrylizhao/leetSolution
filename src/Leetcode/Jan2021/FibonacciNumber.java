package Leetcode.Jan2021;

/**
 *  509. 斐波那契数
 *  #递归
 */
public class FibonacciNumber {
    /*
        给你 n ，请计算 F(n) 。 F是第n个斐波那契数
     */
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /*
        动态规划
     */
    public int fib_dp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
