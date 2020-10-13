package Leetcode.oct2020;

/**　
 * 24. 两两交换链表中的节点
 * #链表
 */
public class SwapNodesInPairs {
    /*
        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
        给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode next = temp.next;
        temp.next = head;
        head = head.next;
        temp.next.next = swapPairs(next);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getListNodeFromArray(new int[] {1, 2, 3, 4});
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode res = swapNodesInPairs.swapPairs(head);
        System.out.println(res);
    }

}
