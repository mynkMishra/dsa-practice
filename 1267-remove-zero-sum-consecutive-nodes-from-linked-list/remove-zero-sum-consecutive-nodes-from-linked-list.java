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
    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode front = new ListNode(0, head);
        ListNode curr = front;

        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();

        int prefixSum = 0;
        while(curr != null){
            prefixSum += curr.val;
            map.put(prefixSum, curr);
            curr = curr.next;
        }

        curr = front;
        prefixSum = 0;

        while(curr != null){
            prefixSum += curr.val;
            curr.next = map.get(prefixSum).next;
            curr = curr.next;
        }

        return front.next;
    }
}