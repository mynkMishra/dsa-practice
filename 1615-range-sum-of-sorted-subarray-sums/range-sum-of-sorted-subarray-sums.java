class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {

        long mod = 1000000000 + 7;
        int N = nums.length;
        LinkedList<Long> queue = new LinkedList<Long>();
        ArrayList<Long> aux = new ArrayList<Long>();

        int idx = N - 1;

        while(idx >= 0){
            int size = queue.size();

            while(size > 0){
                long el = queue.removeFirst();
                aux.add(el);
                queue.addLast(el+ (long)nums[idx]);
                size--;
            }
            queue.addLast((long)nums[idx]);
            idx--;
        }

        while(queue.size() > 0){
            long el = queue.removeFirst();
            aux.add(el); 
        }     

        Collections.sort(aux, (a, b) -> Long.compare(a,b));

        long ans = 0;
        for(int i = left; i <= right; i++){
            ans += aux.get(i - 1);
        }

        return (int)(ans%mod);
    }

}