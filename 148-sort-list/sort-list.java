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
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    public ListNode sort(ListNode node){

        if(node == null || node.next == null){
            return node;
        }

        ListNode s = node;
        ListNode f = node;
        ListNode prev = null;

        while(f != null){
            f = f.next;
           
            if(f != null){  
                prev = s; 
                s = s.next;
                f = f.next;
            }
        }

        prev.next = null;
        ListNode left = sort(node);
        ListNode right = sort(s);
        
        ListNode t = merge(left, right);
        return t;
    }

    public ListNode merge(ListNode left, ListNode right){

        ListNode newHead = new ListNode(0);
        ListNode res = newHead;

        while(left != null && right != null){

            if(left.val < right.val){
                res.next = new ListNode(left.val);
                left = left.next;
            }else{
                res.next = new ListNode(right.val);
                right = right.next;
            }
            res = res.next;
        }

        while(left != null){
            res.next = new ListNode(left.val);
            left = left.next;
            res = res.next;
        }

        while(right != null){
            res.next = new ListNode(right.val);
            right = right.next;
            res = res.next;
        }

        return newHead.next;
    }
}