package Leetcode.oct2020;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * #字符串 #双指针
 */
public class BackspaceStringCompare {
    /*
        给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
        # 代表退格字符。
        注意: 如果对空文本输入退格字符，文本继续为空。

        输入：S = "ab#c", T = "ad#c"
        输出：true
        解释：S 和 T 都会变成 “ac”。

        输入：S = "a#c", T = "b"
        输出：false
        解释：S 会变成 “c”，但 T 仍然是 “b”。
     */
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        Stack<Character> ss = new Stack<>();
        Stack<Character> ts = new Stack<>();
        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();

        for (char sc : s) {
            if(sc == '#') {
                if(!ss.isEmpty()){
                    ss.pop();
                }
            } else {
                ss.push(sc);
            }
        }

        for (char tc : t) {
            if(tc == '#') {
                if(!ts.isEmpty()){
                    ts.pop();
                }
            } else {
                ts.push(tc);
            }
        }

        while(!ss.isEmpty()) {
            sbs.append(ss.pop());
        }

        while(!ts.isEmpty()) {
            sbt.append(ts.pop());
        }

        String sString = sbs.toString();
        String tString = sbt.toString();
        return sString.equals(tString);
    }
}
