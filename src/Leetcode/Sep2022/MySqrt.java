package Leetcode.Sep2022;

public class MySqrt {
    public static int mySqrt(int x) {
        if(x == 1) return 1;
        long left = 0;
        long right = (x >> 1) + 1;
        while(left < right) {
            long mid = left + (right - left) / 2;
            if(mid * mid > x) { // 寻找下界用 > | 寻找上界用 <
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)left - 1;
    }

    public static void main(String[] args) {
        System.out.println(MySqrt.mySqrt(1));
    }
}
