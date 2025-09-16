class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<Integer>();

        for(int n: nums){
            int curr = n;

            while(!stack.isEmpty()){
                int last = stack.get(stack.size() - 1);
                int gcd = gcd(last, curr);
                if(gcd == 1){
                    break;
                }

                curr = lcm(curr, last, gcd);
                stack.remove(stack.size() - 1);
            }
            stack.add(curr);
        }

        return stack;
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a%b);
    }

    public int lcm(long a, long b, long gcd){
        return (int)((long)(a*b)/gcd);
    }
}