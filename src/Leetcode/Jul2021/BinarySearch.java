package Leetcode.Jul2021;

/**
 *  二分查找
 */
public class BinarySearch {
    /**
     *  二分查找
     * @param nums 数组
     * @param target 目标值
     * @return 目标值在数组中的下标
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        //左右都包含的封闭区间, 所以终止条件是left > right
        int left = 0;
        int right = len - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) { //target应该落在左区间
                right = mid - 1;
            } else if(nums[mid] < target) { //target应该落在右区间
                left = mid + 1;
            }
        }

        return -1;
    }
}
