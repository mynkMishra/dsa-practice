class Solution {

    Map<String, Integer> hm;
    public int maximumScore(int[] nums, int[] multipliers) {
        int N = nums.length;
        int M = multipliers.length;

        hm = new HashMap<>();
        return solve(0, N - 1, 0, nums, multipliers);
    }

    public int solve(int lower, int upper, int m, int[] nums, int[] mul){

        if(lower > upper){
            return 0;
        }

        if(m == mul.length){
            return 0;
        }

        if(hm.containsKey(lower + "#" + upper + "#" + m)){
            return hm.get(lower + "#" + upper + "#" + m);
        }

        int lEl = nums[lower];
        nums[lower] = 0;
        int first = solve(lower + 1, upper, m + 1, nums, mul) + mul[m]*lEl;
        nums[lower] = lEl;

        int uEl = nums[upper];
        nums[upper] = 0;
        int last = solve(lower, upper - 1, m + 1, nums, mul) + mul[m]*uEl;
        nums[upper] = uEl;

        hm.put(lower + "#" + upper + "#" + m,  Math.max(first, last));
        return Math.max(first, last);
    }
}