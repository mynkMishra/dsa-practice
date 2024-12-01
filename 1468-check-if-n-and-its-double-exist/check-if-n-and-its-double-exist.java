class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++){
            if((arr[i]%2 == 0 && hs.contains(arr[i]/2)) || hs.contains(2*arr[i])){
                return true;
            }else{
                hs.add(arr[i]);
            }
        }

        return false;
    }
}