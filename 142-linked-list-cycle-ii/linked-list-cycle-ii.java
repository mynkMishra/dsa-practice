/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode s = head;
        ListNode f = head;
        boolean started = false;

        while(f != null){
            if(started && s == f){
                while(head != s){
                    s = s.next;
                    head = head.next;
                }
                return head;
            }
            started = true;
            f = f.next;
            if(f != null){
                f = f.next;
                s = s.next;
            }
        }

        return null;
    }
}