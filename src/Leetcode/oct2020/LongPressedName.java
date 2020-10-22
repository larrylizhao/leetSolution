package Leetcode.oct2020;

/**
 * 925. 长按键入
 * #字符串
 */
public class LongPressedName {
    /*
        检查同一字符是否被输入多次
        输入：name = "alex", typed = "aaleex"
        输出：true
        解释：'alex' 中的 'a' 和 'e' 被长按。

        输入：name = "saeed", typed = "ssaaedd"
        输出：false
        解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     */
    /*
        字符串 typed 的每个字符，有且只有两种「用途」：
        1. 作为 name 的一部分。此时会「匹配」name 中的一个字符
        2. 作为长按键入的一部分。此时它应当与前一个字符相同。
    */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();
        int typedLen = typed.length();
        while(j < typedLen) {
            // 如果i已经越界
            if(i == name.length()) {
                if(nameChar[i - 1] == typedChar[j]) {
                    j++;
                    continue;
                } else {
                    return false;
                }
            }
            // name 与 type 中的字符一样，i,j同时步进
            if(nameChar[i] == typedChar[j]) {
                i++;
                j++;
                continue;
            }
            // j不是首字符且不与前一字符相同
            if(j == 0 || typedChar[j - 1] != typedChar[j]) {
                return false;
            }
            j++;
        }
        return i == name.length();
    }

    public boolean isLongPressedName_succinct(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        LongPressedName longPressedName = new LongPressedName();
        longPressedName.isLongPressedName(name, typed);
    }
}
