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

        ListNode s = head;
        ListNode f = head;
        int i = 0;
        while(i < n){
            f = f.next;
            i++;
        }

        ListNode prev = null;
        ListNode curr = head;
        while(f != null){
            f = f.next;
            prev = s;
            s = s.next;
        }

        if(prev == null){
            return head.next;
        }

        prev.next = s.next;
        return head;
    }
}