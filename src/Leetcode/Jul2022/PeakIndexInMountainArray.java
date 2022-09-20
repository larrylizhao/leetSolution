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

    public static int peakIndexInMountainArray_simp(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid - 1] > arr[mid]) { // mid与mid左侧的元素比较, 如果mid是答案，right=mid不会触发，所以答案要减1
                right = mid;    //通过确定 right=mid会不会触发来决定答案是 right 还是 right - 1
            } else {
                left = mid + 1;
            }
        }
        return right - 1;
    }

    public static int peakIndexInMountainArray_simp2(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid + 1]) { // mid与mid右侧的元素比较，如果mid是答案，right=mid会触发，所以返回right
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray.peakIndexInMountainArray_simp(new int[] {0, 10, 11, 5, 1});
    }
}
