public class Solution {
    public bool CanBeEqual(int[] target, int[] arr) {
        if(arr.Length != target.Length){
            return false;
        }

        Array.Sort(arr);
        Array.Sort(target);

        for(int i = 0; i < arr.Length; i++){
            if(arr[i] != target[i]){
                return false;
            }
        }

        return true;
    }
}