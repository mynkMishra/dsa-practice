class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Integer[]> list = new ArrayList<Integer[]>();

        int k = 0;
        for(List<Integer> l: nums){
            for(Integer i: l){
                Integer[] t = new Integer[2];
                t[0] = i;
                t[1] = k;
                list.add(t);
            }
            k++;
        }

        Collections.sort(list, (a, b) -> a[0] - b[0]);

        int l = 0;
        int r = 0;
        int N = list.size();
        int K = nums.size();

        int[] ans = new int[2];
        ans[0] = -1000000;
        ans[1] = 1000000;

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        while(r < N){
            if(hm.size() == K){
                while(hm.size() == K){
                    if(list.get(r - 1)[0] - list.get(l)[0] < ans[1] - ans[0]){
                        ans[0] = list.get(l)[0];
                        ans[1] = list.get(r - 1)[0];
                    }else if(list.get(r - 1)[0] - list.get(l)[0] == ans[1] - ans[0]){
                        if(list.get(l)[0] < ans[0]){
                            ans[0] = list.get(l)[0];
                            ans[1] = list.get(r - 1)[0];
                        }
                    }

                    hm.put(list.get(l)[1], hm.get(list.get(l)[1]) - 1);
                    if(hm.get(list.get(l)[1]) == 0){
                        hm.remove(list.get(l)[1]);
                    }
                    l++;
                }

                hm.put(list.get(r)[1], hm.getOrDefault(list.get(r)[1], 0) + 1);
                r++;

            }else{
                hm.put(list.get(r)[1], hm.getOrDefault(list.get(r)[1], 0) + 1);
                r++;
            }
        }

        while(hm.size() == K){
            if(list.get(r - 1)[0] - list.get(l)[0] < ans[1] - ans[0]){
                ans[0] = list.get(l)[0];
                ans[1] = list.get(r - 1)[0];
            }else if(list.get(r - 1)[0] - list.get(l)[0] == ans[1] - ans[0]){
                if(list.get(l)[0] < ans[0]){
                    ans[0] = list.get(l)[0];
                    ans[1] = list.get(r - 1)[0];
                }
            }

            hm.put(list.get(l)[1], hm.get(list.get(l)[1]) - 1);
            if(hm.get(list.get(l)[1]) == 0){
                hm.remove(list.get(l)[1]);
            }
            l++;
        }

        return ans;
    }
}