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
            // 如果set中出现重复节点，表示链表有环
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
        // 快指针走两步，慢指针走一步
        // 如果无环，快指针会率先到达终点
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == null) {
                return false;
            }
            fast = fast.next;
            // 快慢指针相遇，说明链表有环
            if(slow == fast) {
                return true;
            }
        }
        // 到达终点，链表无环
        return false;
    }
}
