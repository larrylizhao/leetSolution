package Leetcode.oct2020;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * #链表 #set
 */
public class LinkedListCycle {
    /*
        判断链表是否有环
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 快慢指针法
    public boolean hasCycle_pointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (head != null) {
            if (true) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
