package Leetcode;

public class MagicIndex {

    /*
     *   LC面试题0803 魔术索引
     * https://leetcode-cn.com/problems/magic-index-lcci/
     */
    public int findMagicIndex(int[] nums) {
        return findPos(nums, 0, nums.length - 1);
    }

    int findPos(int[] nums, int i, int j) {
        while (i < j) {
            int mid = (i + j) / 2;
            //二分法关键：确定要寻找的答案在左边还是在右边
            //如果 nums[i] > mid 或者 nums[mid] < i, 说明答案在右半边
            if (nums[i] > mid || nums[mid] < i) {
                i = mid + 1;
            } else {
                int left = findPos(nums, i, mid);
                if (left != -1) {
                    return left;
                } else {
                    return findPos(nums, mid + 1, j);
                }
            }
        }

        return i < nums.length && nums[i] == i ? i : -1;
    }
}
