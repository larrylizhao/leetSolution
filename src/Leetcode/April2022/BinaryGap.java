package Leetcode.April2022;

/**
 *  868. 二进制间距
 *  #字符串 #双指针
 */
public class BinaryGap {
    /*
        给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
        输入：n = 22
        输出：2
        解释：22 的二进制是 "10110" 。
        在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
        第一对相邻的 1 中，两个 1 之间的距离为 2 。
        第二对相邻的 1 中，两个 1 之间的距离为 1 。
        答案取两个距离之中最大的，也就是 2 。
     */
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        char[] binary = binaryString.substring(binaryString.indexOf("1")).toCharArray();
        int maxGap = 0;
        int last1 = 0;
        for (int i = 1; i < binary.length; i++) {
            if(binary[i] == '1') {
                maxGap = Math.max(maxGap, i - last1);
                last1 = i;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int n = 49;
        BinaryGap binaryGap = new BinaryGap();
        binaryGap.binaryGap(n);
    }
}
