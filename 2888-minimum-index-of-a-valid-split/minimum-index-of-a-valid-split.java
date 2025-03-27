class Solution {
    public int minimumIndex(List<Integer> nums) {

        int N = nums.size();
        Map<Integer, Integer> hm = new HashMap<>();

        for(int n: nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        Map<Integer, Integer> curr = new HashMap<>();
        for(int i = 0; i < N; i++){
            int el = nums.get(i);
            curr.put(el, curr.getOrDefault(el, 0) + 1);

            if(curr.get(el) > (i + 1)/2 && (hm.get(el) - curr.get(el)) > (N - i - 1)/2 ){
                return i;
            }
        }

        return -1;
    }

}