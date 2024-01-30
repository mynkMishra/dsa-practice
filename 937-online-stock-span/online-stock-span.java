class StockSpanner {

    class Ele{
        int el;
        int idx;

        Ele(int el, int idx){
            this.el = el;
            this.idx = idx;
        }
    }

    LinkedList<Ele> stack;
    int count;
    public StockSpanner() {
        this.stack = new LinkedList<Ele>();
        this.count = 0;
    }
    
    public int next(int price) {
        while(stack.size() > 0 && stack.peekLast().el <= price){
            stack.removeLast();
        }

        if(stack.size() == 0){
            stack.addLast(new Ele(price, count));
            count++;
            return stack.peekLast().idx + 1;
        }else{
            int idx = stack.peekLast().idx;
            stack.addLast(new Ele(price, count));
            count++;
            return stack.peekLast().idx - idx;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */