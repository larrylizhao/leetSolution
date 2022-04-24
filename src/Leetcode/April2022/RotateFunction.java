package Leetcode.April2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  396. 旋转函数
 *  #数组 #滑动窗口 #前缀和 #动态规划
 */
public class RotateFunction {
    /*
        给定一个长度为 n 的整数数组 nums 。
        假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数 F 为：
        F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
        返回 F(0), F(1), ..., F(n-1)中的最大值 。

        输入: nums = [4,3,2,6]
        输出: 26
        解释:
        F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
        F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
        F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
        F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
        所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
     */

    /*
        递推
     */
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int res = 0;
        int sum = 0;
        // 计算数组和以及F(0)
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            res += nums[i - 1] * (i - 1);
        }
        // 递推 F(n) = F(n-1) - factor + restSum
        for (int i = n - 1, iterate = res; i > -1; i--) {
            int restSum = sum - nums[i];
            int factor = (n - 1) * nums[i];
            iterate = iterate - factor + restSum;
            res = Math.max(iterate, res);
        }
        return res;
    }

    /*
        滑动窗口
     */
    public int maxRotateFunction_slide(int[] nums) {
        int n = nums.length;
        // 求出前缀和
        int[] pre = new int[n * 2 + 1];
        for (int i = 1; i <= 2 * n; i++) {
            pre[i] = pre[i - 1] + nums[(i - 1) % n];
        }
        int ans = 0;
        // 求出F(0)
        for (int i = 1; i <= n; i++) {
            ans += nums[i - 1] * (i - 1);
        }
        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
            cur += nums[(i - 1) % n] * (n - 1);
            cur -= pre[i - 1] - pre[i - n];
            if (cur > ans) ans = cur;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        RotateFunction rotateFunction = new RotateFunction();
        int[] nums = {4,3,2,6};
        rotateFunction.maxRotateFunction(nums);
    }

}
