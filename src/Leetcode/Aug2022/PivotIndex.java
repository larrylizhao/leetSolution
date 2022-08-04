package Leetcode.Aug2022;

/**
 *  724. 寻找数组的中心下标
 *  #前缀和
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] pre = getPre(nums);
        int sum = pre[len - 1];
        for (int i = 0; i < pre.length; i++) {
            if(pre[i] - nums[i] == sum - pre[i]) {
                return i;
            }
        }
        return -1;
    }

    private int[] getPre(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        return pre;
    }
}
