class LRUCache {

    class Node{
        int key;
        int val;

        Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    int size = 0;
    Map<Integer, Integer> hm;
    Map<Integer, Node> nodeHm;
    LinkedList<Node> list;
    public LRUCache(int capacity) {
        size = capacity;
        hm = new HashMap<>();
        nodeHm = new HashMap<>();
        list = new LinkedList<>();
    }
    
    public int get(int key) {
        
        if(hm.get(key) == null){
            return -1;
        }

        list.remove(nodeHm.get(key));
        Node node = new Node(key, hm.get(key));
        list.addLast(node);
        nodeHm.put(key, node);
        return hm.get(key);
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            list.remove(nodeHm.get(key));
            Node node = new Node(key, value);
            list.addLast(node);
            nodeHm.put(key, node);
            hm.put(key, value);
        }else{
            if(size == list.size()){
                Node oldNode = list.removeFirst();
                nodeHm.remove(oldNode.key);
                hm.remove(oldNode.key);
            }

            Node node = new Node(key, value);
            list.addLast(node);
            hm.put(key, value);
            nodeHm.put(key, node);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */