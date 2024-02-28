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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        return convert(head, null);
    }

    public TreeNode convert(ListNode start, ListNode end){

        if(start == end){
            return null;
        }
       
        ListNode mid = start;
        ListNode fast = start;
        while(fast != end){
            fast = fast.next;
            if(fast != null && fast != end){
                fast = fast.next;
                mid = mid.next;
            }
        }
        
        TreeNode node = new TreeNode(mid.val);
        
        node.left = convert(start, mid);
        node.right = convert(mid.next, end);

        return node;
    }
}