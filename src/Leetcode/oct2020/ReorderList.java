package Leetcode.oct2020;

/**
 * 143. 重排链表
 * #链表 #指针
 */
public class ReorderList {
    /*
        给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
        将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
        示例1:
        给定链表 1->2->3->4, 重新排列为 1->4->2->3.

        示例 2:
        给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

     */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(fast == null || fast.next == null || fast.next.next == null) {
            return;
        }
        // 找到倒数第二个节点
        while(fast.next.next != null) {
            fast = fast.next;
        }
        // slow指向下一个中间位置前的节点, 将最后一个节点插入中间位置
        ListNode temp = slow.next;
        slow.next = fast.next;
        fast.next.next = temp;
        fast.next = null;

        // 将slow指向下一个中间位置前的节点
        slow = slow.next.next;
        reorderList(slow);
    }
}
