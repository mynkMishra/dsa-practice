class Solution {

    PriorityQueue<String> pq;
    public String getHappyString(int n, int k) {
        pq = new PriorityQueue<String>((a, b) -> b.compareTo(a));
        // pq.add("");

        solve("a", n, k);
        solve("b", n, k);
        solve("c", n, k);

        if(pq.size() < k){
            return "";
        }

        return pq.poll();
    }

    public void solve(String str, int n, int k){

        if(pq.size() == k){
            return;
        }
        
        if(str.length() == n){
            pq.add(str);
            return;
        }

        if(str.charAt(str.length() - 1) == 'a'){
            solve(str + 'b', n, k);
            solve(str + 'c', n, k);
        }else if(str.charAt(str.length() - 1) == 'b'){
            solve(str + 'a', n, k);
            solve(str + 'c', n, k);
        }else if(str.charAt(str.length() - 1) == 'c'){
            solve(str + 'a', n, k);
            solve(str + 'b', n, k);
        }
    }
}