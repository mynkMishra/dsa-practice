class Solution {
    public int takeCharacters(String s, int k) {
        if(k == 0){
            return 0;
        }

        int l = 0;
        int r = s.length();

        while(l<=r){
            int mid = l + (r - l)/2;

            // if((mid == 1 || !valid(mid - 1, k, s)) && valid(mid, k, s)){
            //     return mid;
            // }

            if(valid(mid, k, s)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l > s.length() ? -1 : l;
    }

    public boolean valid(int len, int k, String s){

        Map<String, Integer> hm = new HashMap<String, Integer>();

        int count = 0;
        for(int i = 0; i < len; i++){
            String str = s.substring(i, i + 1);
            hm.put(str, hm.getOrDefault(str, 0) + 1);

            if(hm.get(str) == k){
                count++;
            }
        }

        int l = len - 1;
        int r = s.length() - 1;

        while(l >= 0){
            if(count == 3){
                return true;
            }
            String strl = s.substring(l, l + 1);
            if(hm.get(strl) == k){
                count--;
            }
            hm.put(strl, hm.getOrDefault(strl, 0) - 1);
            l--;

            String strr = s.substring(r, r + 1);
            hm.put(strr, hm.getOrDefault(strr, 0) + 1);
            r--;

            if(hm.get(strr) == k){
                count++;
            }
        }

        if(count == 3){
            return true;
        }

        return false;
    }
}