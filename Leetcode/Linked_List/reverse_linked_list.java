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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        while (p.next != null) {
            q = p.next;
            p.next = p.next.next;
            q.next = head;
            head = q;           
        }
        return head;
        
    }
}
