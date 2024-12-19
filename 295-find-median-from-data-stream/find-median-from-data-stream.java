class MedianFinder {

    PriorityQueue<Integer> left_max_heap;
    PriorityQueue<Integer> right_min_heap;
    public MedianFinder() {
        left_max_heap = new PriorityQueue<Integer>((a,b) -> b - a);
        right_min_heap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(left_max_heap.size() == 0){
            left_max_heap.add(num);
        }else if(left_max_heap.peek() > num){
            left_max_heap.add(num);
        }else{
            right_min_heap.add(num);
        }
    }
    
    public double findMedian() {
        int diff = left_max_heap.size() - right_min_heap.size();

        if(diff == 0){
            int sum = left_max_heap.peek() + right_min_heap.peek();
            return (double)sum/2.0;
        }else if(diff == 1){
            return (double)left_max_heap.peek();
        }else if(diff > 1){
            int count = left_max_heap.size() + right_min_heap.size();
            if(count%2 == 0){
                while(left_max_heap.size() != right_min_heap.size()){
                    right_min_heap.add(left_max_heap.poll());
                }

                int sum = left_max_heap.peek() + right_min_heap.peek();
                return (double)sum/2.0;
            }else{
                while(left_max_heap.size() != right_min_heap.size() + 1){
                    right_min_heap.add(left_max_heap.poll());
                }

                return (double)left_max_heap.peek();
            }
        }else{
            int count = left_max_heap.size() + right_min_heap.size();
            if(count%2 == 0){
                while(left_max_heap.size() != right_min_heap.size()){
                    left_max_heap.add(right_min_heap.poll());
                }

                int sum = left_max_heap.peek() + right_min_heap.peek();
                return (double)sum/2.0;
            }else{
                while(left_max_heap.size() != right_min_heap.size() + 1){
                    left_max_heap.add(right_min_heap.poll());
                }

                return (double)left_max_heap.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */