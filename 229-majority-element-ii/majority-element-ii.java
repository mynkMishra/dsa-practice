class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidateA = Integer.MIN_VALUE;
        int candidateB = Integer.MIN_VALUE;

        int countA = 0;
        int countB = 0;

        for(int el: nums){

            if(candidateA == el){
                countA++;
            }else if(candidateB == el){
                countB++;
            }else if(countA == 0){
                candidateA = el;
                countA++;
            }else if(countB == 0){
                candidateB = el;
                countB++;
            }else{
                countA--;
                countB--;
            }
        }

        int freqA = 0;
        int freqB = 0;

        for(int el: nums){
            if(el == candidateA){
                freqA++;
            }else if(el == candidateB){
                freqB++;
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        if(freqA > n/3){
            list.add(candidateA);
        }

        if(freqB > n/3){
            list.add(candidateB);
        }

        return list;
    }
}