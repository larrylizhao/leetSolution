package Leetcode.Aug2022;

import java.util.Arrays;

/**
 *  1385. 两个数组间的距离值
 *  #二分
 */
public class FindTheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i : arr1) {
            if(check(i, arr2, d)) {
                count++;
            }
        }
        return count;
    }

    private boolean check(int i, int[] arr, int d) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == i) {
                return false;
            } else if(arr[mid] > i) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.abs(arr[left] - i) > d && (left - 1 < 0 || Math.abs(arr[left - 1] - i) > d) && (left + 1 >= arr.length || Math.abs(arr[left + 1] - i) > d);
    }

    public static void main(String[] args) {
        FindTheDistanceValue findTheDistanceValue = new FindTheDistanceValue();
        int[] arr = new int[]{-3, -3, 4, -1, -10};
        int[] arr2 = new int[]{7, 10};
        int count = findTheDistanceValue.findTheDistanceValue(arr, arr2, 12);
        System.out.println("Count is: " + count);
    }
}
