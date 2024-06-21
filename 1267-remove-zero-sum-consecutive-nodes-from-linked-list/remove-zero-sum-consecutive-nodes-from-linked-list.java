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
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();

        int sum = 0;
        ListNode curr = head;

        while(curr != null){
            sum += curr.val;
            if(sum == 0){
                head = curr.next;
                map.clear();
            }else if(map.get(sum) == null){
                map.put(sum, curr);
            }else{
               
                int t = sum;
                ListNode xer =  map.get(sum).next;
                while(xer != null && xer != curr){
                    map.remove(t + xer.val);
                    t += xer.val;
                    xer = xer.next;
                }
                 map.get(sum).next = curr.next;
            }
            
            curr = curr.next;
        }

        return head;

    }
}