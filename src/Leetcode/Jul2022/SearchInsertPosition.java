package Leetcode.Jul2022;

/**
 *  35. 搜索插入位置
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;        // 搜索的范围为[0, nums.length)
        while(left < right) {           // mid的取值范围: [left, right) 终止条件 left == right
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) { // 更新区间为 [mid+1, right)
                left = mid + 1;
            } else if(nums[mid] > target) { // 更新区间为 [left, mid)
                right = mid;
            }
        }
        return left;
    }
}
