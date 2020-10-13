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
}
