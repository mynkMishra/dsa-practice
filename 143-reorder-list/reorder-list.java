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
    public void reorderList(ListNode head) {
        
        ListNode s = head;
        ListNode f = head;
        int count = 0;

        while(f.next != null){
            f = f.next;
            count++;
            if(f.next != null){
                count++;
                f = f.next;
                s = s.next;
            }
        }

        ListNode r = s.next;
        s.next = null;
        s = reverse(r);

        ListNode res = head;
        int i = 0;

        while(head != null && s != null){
            if(i % 2 == 0){
                head = head.next;
                res.next = s;
            }else{
                s = s.next;
                res.next = head;
            }
            res = res.next;
            i++;
        }          
    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(next != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}