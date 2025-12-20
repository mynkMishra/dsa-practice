class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int pre = 1;
        int post = 1;

        int i = 0;
        int j = 0;

        int zerosCount = 0;

        int[] res = new int[nums.length];

        while(i < nums.length){

            if(nums[i] != 0){
                pre = pre * nums[i];
            }else{
                zerosCount++;

                if(zerosCount == 1){
                    j = i + 1;
                    while(j < nums.length){
                        post = post * nums[j];
                        if(nums[j] == 0){
                            zerosCount++;
                            break;
                        }
                        j++;
                    }

                    if(zerosCount == 1){
                        res[i] = pre*post;
                    }

                    return res;
                }
            }

            i++;
        }

        int total = 1;
        for(int el: nums){
            total = total * el;
        }

        for(i = 0; i < nums.length; i++){
            res[i] = total / nums[i];
        }

        return res;
    }
}