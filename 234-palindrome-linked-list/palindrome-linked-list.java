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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        StringBuilder sb1 = new StringBuilder();
        int count = 0;
        int i = 0;
        while(fast != null){
            count++;
            fast = fast.next;
            if(fast != null){
                count++;
                sb1.append(slow.val + "");
                slow = slow.next;
                fast = fast.next;
            }
        }
        i = sb1.length() - 1;

        if(count % 2 != 0){
            slow = slow.next;
        }

        while(slow != null){
            if(!sb1.substring(i, i + 1).equals(slow.val + "")){
                return false;
            }
            i--;
            slow = slow.next;
        }

        return true;
    }
}