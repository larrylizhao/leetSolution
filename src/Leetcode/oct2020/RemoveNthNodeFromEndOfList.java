package Leetcode.oct2020;

import java.util.ArrayList;
import java.util.List;

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
        //  循环遍历保存每一个节点并获得链表长度
        List<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;
        int listLen = 0;
        while(temp != null) {
            nodes.add(temp);
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
