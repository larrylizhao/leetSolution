package Leetcode.April2022;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  796. 旋转字符串
 *  #字符串
 */
public class RotateString {
    /*
        给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
        s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
        输入: s = "abcde", goal = "cdeab"
        输出: true

        输入: s = "abcde", goal = "abced"
        输出: false
     */
    public boolean rotateString(String s, String goal) {
        /*
            在原字符串上找到旋转后字符串的第一个字串，并分两段比对字符串
         */
        char[] sChar = s.toCharArray();
        char[] goalChar = goal.toCharArray();
        char divider = sChar[0];
        int position = goal.indexOf(divider);



    }

    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }

}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            return u1.number.compareTo(u2.number);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}

