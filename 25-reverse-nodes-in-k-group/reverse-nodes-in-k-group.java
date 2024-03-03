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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1){
            return head;
        }
        
        int count = 0;
        ListNode newHead = null;
        ListNode tempPrev = null;
        ListNode temp = head;
        ListNode lh = head;
        ListNode lt = null;

        while(temp != null){
            if(count == 0){
                lh = temp;
                temp = temp.next;
                count++;
            }else if(count == k - 1){
                lt = temp;
                ListNode prev = null;
                ListNode next = null;
                ListNode curr = lh;

                while(prev != lt){
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                lh.next = curr;
                if(tempPrev != null){
                    tempPrev.next = lt;
                }else{
                    newHead = lt;
                }
                
                tempPrev = lh;
                temp = curr;
                count = 0;
            }else{
                temp = temp.next;
                count++;
            }
        }

        return newHead;
    }
}