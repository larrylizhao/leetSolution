package Leetcode.Nov2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
//        List<Integer> res = new ArrayList<>();
        int[] intersection = new int[len1 + len2 + 2];
        int index = 0;

        // 任何一个数组遍历完就结束遍历，当一个数组遍历完便可以确定不会再有相同元素。
        while(i > -1 && j > -1) {
            // 元素相同且与上一个元素不同则加入res中
            if(nums1[i] == nums2[j]) {
                if(i == len1 || nums1[i] != nums1[i +1]) {
//                    res.add(nums1[i]);
                    intersection[index++] = nums1[i];
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
//        return res.stream().mapToInt(e->e).toArray();
        // List to array is slowly
        return Arrays.copyOfRange(intersection, 0, index);
    }

        public int[] intersection_col(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<Integer>();
            Set<Integer> set2 = new HashSet<Integer>();
            for (int num : nums1) {
                set1.add(num);
            }
            for (int num : nums2) {
                set2.add(num);
            }
            return getIntersection(set1, set2);
        }

        public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
            // clean way to always make the param set1 has smaller size
            if (set1.size() > set2.size()) {
                return getIntersection(set2, set1);
            }
            // HashSet查找的复杂度是O(1)
            Set<Integer> intersectionSet = new HashSet<>();
            for (int num : set1) {
                if (set2.contains(num)) {
                    intersectionSet.add(num);
                }
            }
            int[] intersection = new int[intersectionSet.size()];
            int index = 0;
            for (int num : intersectionSet) {
                intersection[index++] = num;
            }
            return intersection;
        }


    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] res = intersectionOfTwoArrays.intersection(nums1, nums2);
        System.out.println(res);
    }
}
