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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) { 
            return list1;
        }
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode prev1 = null;
        ListNode nxt = curr2.next;
        if (curr1.val > curr2.val) {
            curr2.next = curr1;
            prev1 = curr2;
            curr2 = nxt;
            if (nxt != null) nxt = nxt.next;
            list1 = prev1;
        }
        while (curr1 != null & curr2 != null) {
            if (curr1.val > curr2.val) {
                curr2.next = curr1;
                if (prev1 != null) prev1.next = curr2;
                prev1 = curr2;
                curr2 = nxt;
                if (nxt != null) nxt = nxt.next;
            }
            else { 
                prev1 = curr1;
                curr1 = curr1.next;                
            }
        }
        if (curr2 != null) {
            prev1.next = curr2;
        }
        return list1;
        
    }
}
