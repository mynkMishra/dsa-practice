class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int[] n: nums1){
            hm.put(n[0], n[1]);
        }

        for(int[]n : nums2){
            if(hm.get(n[0]) != null){
                hm.put(n[0], hm.get(n[0]) + n[1]);
            }else{
                hm.put(n[0], n[1]);
            }
        }

        int[][] res = new int[hm.size()][2];

        int i = 0; int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i][0] < nums2[j][0]){
                res[k][0] = nums1[i][0];
                res[k][1] = hm.get(nums1[i][0]);
                i++;
            }else{
                res[k][0] = nums2[j][0];
                res[k][1] = hm.get(nums2[j][0]);
                if(nums1[i][0] == nums2[j][0]){
                    i++;
                }
                j++;
            }
            k++;
        }

        while(i < nums1.length){
            res[k][0] = nums1[i][0];
            res[k][1] = hm.get(nums1[i][0]);
            i++;
            k++;
        }

        while(j < nums2.length){
            res[k][0] = nums2[j][0];
            res[k][1] = hm.get(nums2[j][0]);
            j++;
            k++;
        }

        return res;
    }
}