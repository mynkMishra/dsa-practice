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
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;

        while(fast != null){
            if(count > n){
                prev = slow;
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        
        if(prev == null){
            return head.next;
        }

        if(prev.next != null){
            prev.next = prev.next.next;
        }

        // if(prev == head){
        //     head = prev.next;
        // }else{
        //     // System.out.println(prev.val);
        //     if(prev.next != null){
        //         prev.next = prev.next.next;
        //     }
            
        // }

        return head;
    }
}