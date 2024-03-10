class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int el: nums1){
            map.put(el, 1);
        }

        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int el: nums2){
            if(map.get(el) != null){
                list.add(el);
                map.remove(el);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}