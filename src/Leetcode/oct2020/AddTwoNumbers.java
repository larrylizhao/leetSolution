package Leetcode.oct2020;

/**
 * 2. 两数相加
 *
 */
public class AddTwoNumbers {
    /*
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return l1;
    }


    public ListNode addTwoNumbers_NumberFormatException(ListNode l1, ListNode l2) {
        int num = getNumberFromListNode(l1) + getNumberFromListNode(l2);
        String numStr = String.valueOf(num);
        char[] numChars = numStr.toCharArray();
        ListNode res = new ListNode();
        ListNode temp = res;
        for (int i = numChars.length - 1; i > 0 ; i--) {
            temp.val = numChars[i] - '0';
            temp.next = new ListNode();
            temp = temp.next;
        }
        temp.val = numChars[0] - '0';
        temp.next = null;
        return res;
    }

    private int getNumberFromListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while(listNode != null) {
            sb.append(listNode.val);
            listNode = listNode.next;
        }
        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListNodeFromArray(new int[] {9});
        ListNode l2 = ListNode.getListNodeFromArray(new int[] {1,9,9,9,9,9,9,9,9,9});
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode res = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(res);
    }
}
