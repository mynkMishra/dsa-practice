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
        Map<Node, Node> oldHm = new HashMap<>();
        Map<Node, Node> newHm = new HashMap<>();

        Node newHead = null;
        Node temp1 = head;
        Node temp2 = null;

        while(temp1 != null){
            Node newNode = new Node(temp1.val);

            if(newHead == null){
                newHead = newNode;
                temp2 = newNode;
            }else{
                temp2.next = newNode;
                temp2 = temp2.next;
            }
            
            oldHm.put(newNode, temp1);
            newHm.put(temp1, newNode);
            temp1 = temp1.next;
        }

        temp2 = newHead;

        while(temp2 != null){
            Node oldN = oldHm.get(temp2);
            temp2.random = newHm.get(oldN.random);
            temp2 = temp2.next;
        }

        return newHead;
    }
}