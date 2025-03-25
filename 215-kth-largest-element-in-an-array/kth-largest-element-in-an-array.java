class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minH = new PriorityQueue<>();

        for(int n: nums){
            if(minH.size() < k){
                minH.add(n);
            }else{
                if(minH.peek() < n){
                    minH.poll();
                    minH.add(n);
                }
            }
        }

        return minH.peek();
    }
}