package Leetcode;

/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings
 * add % 10代表相加结果
 * add / 10代表进位
 */
public class LC415 {

    public static void main(String[] args) {
        String str1 = "11";
        String str2 = "99";
        LC415 lc415 = new LC415();
        String result = lc415.addStrings(str1, str2);
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        // 用于标记进位
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //由尾至头同时遍历两个字符串
        while(i >= 0 || j >= 0) {
            // 如果其中一个字串遍历完了就在前面补0
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int add = n1 + n2 + carry;
            // 保留进位
            carry = add / 10;
            // 获取相加结果
            res.append(add%10);
            i--;
            j--;
        }
        if(carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }


    public String addStrings_recursive(String num1, String num2) {
        return addBinaryHelper(num1, num1.length() - 1, num2, num2.length() - 1, 0);
    }

    //递归helper函数, 用于传入递归辅助参数(数组，指针，进位)
    public String addBinaryHelper(String num1, int indexA, String num2, int indexB, int carry) {
        //触底 - 递归终止条件
        if (indexA < 0 && indexB < 0 && carry == 0){
            return "";
        }
        int n1 = indexA < 0 ? 0 : num1.charAt(indexA--) - '0';
        int n2 = indexB < 0 ? 0 : num2.charAt(indexB--) - '0';
        int add = n1 + n2 + carry;
        int digit = add % 10;
        carry = add / 10;

        //递归返回值处理 f(n-1)
        String res = addBinaryHelper(num1, indexA, num2, indexB, carry);

        //返回值 f(n) = f(n-1) + digit;
        return res + digit;
    }

    public String addStrings_archive(String num1, String num2) {
        int num1Length = num1.length();
        int num2Length = num2.length();
        int increment = 0;
        int breakIndex;
        final int REDIX = 10;
        int startPoint;
        String leftOver;
        char[] add1;
        char[] add2;
        if(num1Length > num2Length) {
            startPoint = num2Length;
            leftOver = num1.substring(0, num1Length - num2Length);
            add1 = num1.substring(num1Length - num2Length).toCharArray();
            add2 = num2.toCharArray();
        } else if(num2Length > num1Length){
            startPoint = num1Length;
            leftOver = num2.substring(0, num2Length - num1Length);
            add1 = num2.substring(num2Length - num1Length).toCharArray();
            add2 = num1.toCharArray();
        } else {
            startPoint = num1Length;
            leftOver = "";
            add1 = num1.toCharArray();
            add2 = num2.toCharArray();
        }
        StringBuilder result = new StringBuilder();
        for (int i = startPoint - 1; i > -1; i--) {
            int base = 1;
            int num_1 = Integer.parseInt(String.valueOf(add1[i]));
            int num_2 = Integer.parseInt(String.valueOf(add2[i]));
            int value = increment + num_1 + num_2;
            if(value >= 10) {
                increment = 1;
                value -= 10;
            } else {
                increment = 0;
            }
            result.append(Character.forDigit(value * base, REDIX));
            base *= 10;
        }
        if (increment == 1) {
            leftOver = addStrings("1", leftOver);
        }
        result.append(leftOver);
        return result.reverse().toString();
    }
}


