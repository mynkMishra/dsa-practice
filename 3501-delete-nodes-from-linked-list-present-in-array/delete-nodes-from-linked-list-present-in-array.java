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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();

        for(int el: nums){
            hs.add(el);
        }

        ListNode prev = null;
        ListNode node = head;

        while(node != null){
            if(hs.contains(node.val)){
                if(prev == null){
                    head = node.next;
                    node = node.next;
                }else{
                    prev.next = node.next;
                    node = node.next;
                }
            }else{
                prev = node;
                node = node.next;
            }
        }

        return head;
    }
}