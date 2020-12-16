package Leetcode.Dec2020;

import java.util.Arrays;

/**
 *  738. 单调递增的数字
 *  #排序
 */
public class MonotoneIncreasingDigits {
    /*
        找到不大于 n 的最大的数，该数满足从高位到低位的数字非严格递增。
        输入: N = 1234
        输出: 1234

        输入: N = 332
        输出: 299

     */
    /*
        从低位向高位遍历，如果高位大于低位，高位-1，低位变为9
     */
    public int monotoneIncreasingDigits(int N) {
        // String 转为 int array
        int[] arr = (N + "").chars().map(x -> x - '0').toArray();
        //int[] arr = Stream.of(charArr).mapToInt(Integer::intValue).toArray();
        int len = arr.length;
        for (int i = len - 1; i > 0; i--) {
            if(arr[i] < arr[i - 1]) {
                arr[i] = '9';
                // char 转为 int , int 转为 char
                for(int j = )
                arr[i - 1] = Character.forDigit(arr[i - 1] - '0' - 1, 10);
            }
        }
        // int array 转为 String, String 转为 int
        return Integer.parseInt(Arrays.toString(arr));
    }
}
