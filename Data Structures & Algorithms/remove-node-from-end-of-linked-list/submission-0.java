/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        while(n > 0 && second != null){
            n--;
            second = second.next;
        }
        if (n != 0){
            return head;
        }
        if (second == null ){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        ListNode prev = null;
        while(second != null){
            second = second.next;
            prev = first;
            first = first.next;
        }
        prev.next = first.next;
        first.next = null;
        return head;
    }
}
