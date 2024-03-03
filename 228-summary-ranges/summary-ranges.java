class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<String>();

        if(nums.length == 0){
            return result;
        }

        int i = 1;
        int start = nums[0];
        int end = nums[0];
        while(i < nums.length){

            if(nums[i - 1] + 1 == nums[i]){
                end = nums[i];
            }else{
                if(start == end){
                    result.add(start + "");
                }else{
                    result.add(start + "->" + end);
                }
                
                start = nums[i];
                end = nums[i];
            }
            i++;
        }
        if(start == end){
            result.add(start + "");
        }else{
            result.add(start + "->" + end);
        }
        return result;
    }
}