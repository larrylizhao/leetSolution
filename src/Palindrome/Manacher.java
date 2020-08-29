package Palindrome;

public class Manacher {
    private final int[] manacher;

    //得到manacher数组
    public Manacher(String s) {
        String str = addDelimiter(s, '#');
        int len = str.length();
        manacher = new int[len];

        // 双指针，它们是一一对应的，须同时更新
        int maxRight = 0;
        int center = 0;

        // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        int maxLen = 1;
        // 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
        int start = 0;

        for (int i = 0; i < len; i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
                manacher[i] = Math.min(maxRight - i, manacher[mirror]);
            }

            // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
            int left = i - (1 + manacher[i]);
            int right = i + (1 + manacher[i]);

            // left >= 0 && right < sLen 保证不越界
            // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
            while (left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
                manacher[i]++;
                left--;
                right++;
            }
            // 根据 maxRight 的定义，它是遍历过的 i 的 i + manacher[i] 的最大者
            // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + manacher[i] > maxRight) {
                // maxRight 和 center 需要同时更新
                maxRight = i + manacher[i];
                center = i;
            }
            if (manacher[i] > maxLen) {
                // 记录最长回文子串的长度和相应它在原始字符串中的起点
                maxLen = manacher[i];
                start = (i - maxLen) / 2;
            }
        }
    }

    /**
     * 创建预处理字符串
     *
     * @param s      原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private String addDelimiter(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(divide);
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(divide);
        return stringBuilder.toString();
    }

    /**
     *
     * @param start 判断起点
     * @param end   判断终点
     * @return start->end区间是否是回文串
     */
    public boolean isPalindrome(int start, int end) {
        start = start*2 + 1;
        end = end*2 + 1;
        int mid = (start+end)/2;
        //区间长度小于以mid为中心的回文串长度，则start->end一定是回文串
        return 0 <= mid && mid < manacher.length && end - start + 1 <= 2 * manacher[mid];
    }

}
