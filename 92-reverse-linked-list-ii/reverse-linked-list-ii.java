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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode rStart = null;
        ListNode rEnd = null;
        ListNode rPre = null;
        ListNode rPost = null;
        ListNode temp = head;
        ListNode prev = null;
        int count = 1;

        while(temp != null){
            if(count < left){
                if(count == left - 1){
                    rPre = temp;
                }
                temp = temp.next;
                count++;
            }else {
                rStart = temp;
                
                ListNode next = null;
                while(count <= right){
                    next = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = next;
                    count++;
                }
                if(rPre != null){
                    System.out.println(prev.val);
                    rPre.next = prev;
                }

                if(rStart != null){
                    // System.out.println(rStart.val + " " + next.val);
                    rStart.next = next;
                }
                break;
            }
        }

        if(left == 1){
            return prev;
        }
        return head;

    }
}