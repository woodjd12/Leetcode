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
        ListNode end = head;
        ListNode nnode = head;
        int length = 0;
        while (end != null) {
            end = end.next;
            length++;
        }
        if (length - n == 0) {
            head = head.next;
            return head;
        }
        if (length - n == 1) { 
            head.next = head.next.next;
            return head;
        }
        int counter = 0;
        while (counter < (length - n - 1)) {
            nnode = nnode.next;
            counter++;
        }
        nnode.next = nnode.next.next;
        return head;
    }
}
