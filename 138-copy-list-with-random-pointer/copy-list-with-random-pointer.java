/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null){
            return head;
        }

        Map<Node, Integer> map = new HashMap<Node, Integer>();

        Node curr = head;

        int idx = 0;
        while(curr != null){
            map.put(curr, idx++);
            curr = curr.next;
        }

        curr = head;

        Node newHead = new Node(head.val);
        Node newCurr = newHead;
        curr = curr.next;

        idx = 0;
        Map<Integer, Node> newMap = new HashMap<Integer, Node>();
        newMap.put(idx++, newHead);

        while(curr != null){
            newCurr.next = new Node(curr.val);
            newMap.put(idx++, newCurr.next);
            curr = curr.next;
            newCurr = newCurr.next;
        }

        curr = head;
        newCurr = newHead;

        while(curr != null){
            newCurr.random = newMap.get(map.get(curr.random));
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;

    }
}