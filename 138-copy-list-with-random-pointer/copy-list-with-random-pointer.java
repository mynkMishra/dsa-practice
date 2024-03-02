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
        Map<Node, Node> map = new HashMap<Node, Node>();

        Node newHead = null;
        Node temp = head;
        Node newTemp = null;
        while(temp != null){
            if(newHead == null){
                newHead = new Node(temp.val);
                newTemp = newHead;
                map.put(temp, newHead);
                temp = temp.next;
            }else{
                newTemp.next = new Node(temp.val);
                newTemp = newTemp.next;
                map.put(temp, newTemp);
                temp = temp.next;
            }
        }

        temp = head;
        newTemp = newHead;
        while(temp != null){
            newTemp.random = map.get(temp.random);
            temp = temp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}