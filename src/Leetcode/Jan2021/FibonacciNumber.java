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
}
