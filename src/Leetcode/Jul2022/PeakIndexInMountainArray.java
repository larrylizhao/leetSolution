package Leetcode.Jul2022;

/**
 *  852. 山脉数组的峰顶索引
 *  #二分
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if(arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if(arr[mid] < arr[mid -1] && arr[mid] > arr[mid + 1]) {
                right = mid;
            }
        }
        return left;
    }
}
