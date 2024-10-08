/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        
        int l = 0;
        int r = reader.length() - 1;

        while(l<=r){
            int mid = l + (r - l)/2;

            int comp = 0;

            if(((r - l + 1) & 1) == 0){
                comp = reader.compareSub(l, mid, mid + 1, r);
            }else{
                comp = reader.compareSub(l, mid - 1 < l ? l : mid - 1, mid + 1 > r ? r : mid + 1, r);
            }

            if(comp == 0){
                return mid;
            }
            if(comp > 0){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }
}