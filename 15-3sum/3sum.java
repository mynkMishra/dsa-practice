class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i - 1] != nums[i]){
                int sum = -nums[i];
                int l = i + 1;
                int r = nums.length - 1;

                while(l < r){
                    if(nums[l] + nums[r] > sum){
                        r--;
                    }else if(nums[l] + nums[r] < sum){
                        l++;
                    }else{

                        while(l < r && nums[l] == nums[l + 1]){
                            l++;
                        }

                        while(l < r && nums[r - 1] == nums[r]){
                            r--;
                        }
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[l]);
                        li.add(nums[r]);

                        l++;
                        r--;

                        list.add(li);
                    }
                }
            }
        }

        return list;
    }
}