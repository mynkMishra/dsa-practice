class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;

        int a1 = 0;
        if(N2%2 != 0){
            for(int n: nums1){
                a1 = (a1 ^ n);
            }
        }

        int a2 = 0;
        if(N1%2 != 0){
            for(int n: nums2){
                a2 = (a2 ^ n);
            }
        }

        return a1^a2;
    }
}