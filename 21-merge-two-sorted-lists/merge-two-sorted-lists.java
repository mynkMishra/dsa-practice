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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode start = null;
        ListNode temp = null;

        while(list1 != null && list2 != null){
            if(start == null){
                if(list1.val < list2.val){
                    start = list1;
                    temp = start;
                    list1 = list1.next;
                }else{
                    start = list2;
                    temp = start;
                    list2 = list2.next;
                }
            }else{
                // System.out.println(list1.val + " " + list2.val);
                 if(list1.val < list2.val){
                    temp.next = list1;
                    temp = temp.next;
                    list1 = list1.next;
                }else{
                    temp.next = list2;
                    temp = temp.next;
                    list2 = list2.next;
                }
            }
        }

        while(list1 != null){
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }

        while(list2 != null){
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }

        return start;
    }
}