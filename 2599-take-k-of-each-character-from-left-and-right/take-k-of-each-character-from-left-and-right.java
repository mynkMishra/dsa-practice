class Solution {
    public int takeCharacters(String s, int k) {
        if(k == 0){
            return 0;
        }
        int[] arr = new int[3];

        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            arr[idx]++;
        }

        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= k){
                count++;
            }
        }

        if(count < 3){
            return -1;
        }

        int l = 0;
        int r = 0;
        int N = s.length();
        int[] aux = new int[3];
        int ans = Integer.MIN_VALUE;

        while(l < N && r < N){
            // System.out.println(l + " " + r + " " + count);
            if(count == 3){
                ans = Math.max(ans, r - l);
                int idx = s.charAt(r) - 'a';
                aux[idx]++;
                if(arr[idx] - aux[idx] < k){
                    count--;
                }
                r++;
            }else{
                int idx = s.charAt(l) - 'a';
                aux[idx]--;
                if(arr[idx] - aux[idx] == k){
                    count++;
                }
                l++;                
            }
        }
        if(count == 3){
            ans = Math.max(ans, r - l);
        }
        return N - ans;
    }
}