class FirstUnique {

    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    Queue<Integer> queue = new LinkedList<Integer>();

    public FirstUnique(int[] nums) {
        for(int el: nums){
            if(hm.get(el) == null){
                hm.put(el, 1);
                queue.add(el);
            }else{
                hm.put(el, hm.get(el) + 1);
            }
        }
    }
    
    public int showFirstUnique() {
        while(queue.size() != 0 && hm.get(queue.peek()) > 1){
            queue.remove();
        }

        if(queue.size() == 0){
            return -1;
        }

        return queue.peek();
    }
    
    public void add(int value) {
        if(hm.get(value) == null){
            hm.put(value, 1);
            queue.add(value);
        }else{
            hm.put(value, hm.get(value) + 1);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */