package Leetcode.oct2020;

/**
 * 344. 反转字符串
 */
public class ReverseString {
    /*
        输入：["H","a","n","n","a","h"]
        输出：["h","a","n","n","a","H"]
     */
    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;
        char temp;
        while (low < high) {
            temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
