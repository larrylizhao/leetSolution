package Leetcode.oct2020;

import java.util.HashMap;
import java.util.Map;

/**
 * 19. 删除链表的倒数第N个节点
 *  #链表
 */
public class RemoveNthNodeFromEndOfList {
    /*
        给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
        示例：
        给定一个链表: 1->2->3->4->5, 和 n = 2.
        当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n < 1) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // fast指针先前移n+1步
        while(n > -1 && fast != null) {
            fast = fast.next;
            n--;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow指向倒数第n节点的前一节点
        slow.next = slow.next.next;

        // dummy.next代表头节点
        return dummy.next;
    }

    // 遍历一次，利用HashMap记录下标与节点映射信息
    public ListNode removeNthFromEnd_map(ListNode head, int n) {
        if(n < 1) {
            return head;
        }
        //  循环遍历保存每一个节点并获得链表长度
        Map<Integer, ListNode> nodes = new HashMap<>();
        ListNode temp = head;
        int listLen = 0;
        while(temp != null) {
            nodes.put(listLen, temp);
            temp = temp.next;
            listLen++;
        }

        // 倒数第n>=listLen直接删除头节点
        if(n >= listLen) {
            head = head.next;
            return head;
        }

        // 倒数第一，直接删除最后一个
        ListNode prev = nodes.get(listLen - n - 1);
        if(n == 1) {
            prev.next = null;
            return head;
        }

        // 其余情况使得prev.next = nextr
        ListNode next = nodes.get(listLen - n + 1);
        prev.next = next;
        return head;
    }
}
