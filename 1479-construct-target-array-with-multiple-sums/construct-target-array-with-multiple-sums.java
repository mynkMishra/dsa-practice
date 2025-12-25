class Solution {
    public boolean isPossible(int[] target) {
        
        long sum = Arrays.stream(target).asLongStream().sum();

        PriorityQueue<Long> maxH = new PriorityQueue<>(Collections.reverseOrder());

        for(long el: target){
            maxH.add(el);
        }

        while(true){
            long el = maxH.poll();
            sum -= el;
            if(el == 1 || sum == 1){
                return true;
            }

            if(sum > el || sum == 0 || el%sum == 0){
                return false;
            }

            el %= sum;
            sum += el;

            maxH.add(el);
        }

    }
}

// 8,5
// 3,5
// 3,2
// 1,2
// 1,1

// 9,5,3 = 17 - 9
// 5,3,1
// 3,1,1
// 1,1,1

// 2,1,1,1 = 5 - 2 + 1
// 1,1,1,1 = 
