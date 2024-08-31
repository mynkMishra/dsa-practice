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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // l1 = reverse(l1);
        // l2 = reverse(l2);

        ListNode res = null;
        ListNode newHead = null;

        int carry = 0;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val + carry;
            if(val > 9){
                carry = 1;
            }else{
                carry = 0;
            }

            if(res == null){
                res = new ListNode(val%10);
                newHead = res;
            }else{
                res.next = new ListNode(val%10);
                res = res.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int val = l1.val + carry;
            if(val > 9){
                carry = 1;
            }else{
                carry = 0;
            }
            res.next = new ListNode(val%10);
            res = res.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int val = l2.val + carry;
            if(val > 9){
                carry = 1;
            }else{
                carry = 0;
            }
            res.next = new ListNode(val%10);
            res = res.next;
            l2 = l2.next;
        }

        if(carry == 1){
            res.next = new ListNode(1);
        }

        return newHead;
    }

    public ListNode reverse(ListNode node){

        ListNode prev = null;
        ListNode curr = node;
        ListNode next = node;

        while(next != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}