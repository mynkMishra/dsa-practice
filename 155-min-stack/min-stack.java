class MinStack {

    class Node{
        int val;
        int min;

        Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    LinkedList<Node> stack;

    public MinStack() {
        stack = new LinkedList<Node>();
    }
    
    public void push(int val) {
        if(stack.size() == 0){
            stack.addLast(new Node(val, val));
        }else{
            Node top = stack.getLast();
            if(top.min <= val){
              stack.addLast(new Node(val, top.min));  
            }else{
                stack.addLast(new Node(val, val));
            }
        }
    }
    
    public void pop() {
        stack.removeLast();
    }
    
    public int top() {
        return stack.getLast().val;
    }
    
    public int getMin() {
        Node top = stack.getLast();
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */