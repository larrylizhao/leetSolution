package Leetcode.Nov2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 349. 两个数组的交集
 * #数组
 */
public class IntersectionOfTwoArrays {
    /*
        给定两个数组，编写一个函数来计算它们的交集。
        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length - 1;
        int len2 = nums2.length - 1;
        int i = len1;
        int j = len2;
        List<Integer> res = new ArrayList<>();

        // 任何一个数组遍历完就结束遍历，当一个数组遍历完便可以确定不会再有相同元素。
        while(i > -1 && j > -1) {
            // 元素相同且与上一个元素不同则加入res中
            if(nums1[i] == nums2[j]) {
                if(i == len1 || nums1[i] != nums1[i +1]) {
                    res.add(nums1[i]);
                }
                i--;
                j--;
                continue;
            }

            // num1大就i--
            if(nums1[i] > nums2[j]) {
                i--;
                continue;
            }

            // num2大就j--
            if(nums1[i] < nums2[j]) {
                j--;
            }
        }

        // List<Integer> 转 int[]
        return res.stream().mapToInt(e->e).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] res = intersectionOfTwoArrays.intersection(nums1, nums2);
        System.out.println(res);
    }
}
