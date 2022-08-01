package Leetcode.Jul2022;

/**
 *  367. 有效的完全平方数
 *  #二分
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = (num >> 1) + 1;
        while(left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * left == num;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        isPerfectSquare.isPerfectSquare(9);
    }

}
