package Leetcode.oct2020;

public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }

 public static ListNode getListNodeFromArray(int[] arr) {
  ListNode listNode = new ListNode();
  ListNode temp = listNode;
  for(int i = 0; i < arr.length - 1; i++) {
   temp.val = arr[i];
   temp.next = new ListNode();
   temp = temp.next;
  }
  temp.val = arr[arr.length - 1];
  temp.next = null;
  return listNode;
 }
}
