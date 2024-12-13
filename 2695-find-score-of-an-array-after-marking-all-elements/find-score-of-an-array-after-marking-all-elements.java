class Solution {
    public long findScore(int[] nums) {

        int N = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (arr1, arr2) -> arr1[0] == arr2[0] ? 
                            (arr1[1] - arr2[1]) : 
                            (arr1[0] - arr2[0]) );

        for(int i = 0; i < N; i++){
            pq.add(new int[]{ nums[i], i});
        }

        boolean[] visited = new boolean[N];
        long sum = 0;

        while(pq.size() > 0){
            int[] p = pq.poll();
            int el = p[0];
            int idx = p[1];

            if(!visited[idx]){
                sum = (long)(sum + (long)el);

                visited[idx] = true;

                if(idx - 1 >= 0 && !visited[idx - 1]){
                    visited[idx - 1] = true;
                }

                if(idx + 1 < N && !visited[idx + 1]){
                    visited[idx + 1] = true;
                }
                
                
                
            }
        }

        return sum;
    }
}