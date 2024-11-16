class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<Integer>();

        for(int el: arr1){
            int v1 = find(el, arr2);
            int v2 = find(el, arr3);

            if(v1 != -1 && v2 != -1){
                list.add(el);
            }
        }
        return list;
    }

    public int find(int el, int[] arr){

        int l = 0;
        int r = arr.length - 1;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(el == arr[mid]){
                return el;
            }

            if(el < arr[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return -1;
    }
}