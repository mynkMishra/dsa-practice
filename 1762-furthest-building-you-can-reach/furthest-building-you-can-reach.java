class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int count = 0;
        for(int i = 0; i < heights.length - 1; i++){

            if(heights[i] < heights[i + 1]){
                pq.add(heights[i + 1] - heights[i]);
                if(ladders > 0){
                    count++;
                    ladders--;
                }else{
                    if(pq.size() > 0 && bricks >= pq.peek()){
                        bricks -= pq.poll();
                        count++;
                    }
                    else{
                        break;
                    }
                }
            }else{
                count++;
            }
            
        }

        return count;
    }
}