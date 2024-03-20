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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p1 = null;
        ListNode p2 = null;
        int n = 0;

        ListNode temp = list1;

        while(temp != null){
            if(p1 == null && n + 1 == a){
                p1 = temp;
            }
            if(n - 1 == b){
                p2 = temp;
                break;
            }
            temp = temp.next;
            n++;
        }

        p1.next = list2;

        temp = list2;

        while(temp.next != null){
            temp = temp.next;
        }

        if(p2 != null){
            temp.next = p2;
        }

        return list1;
    }
}