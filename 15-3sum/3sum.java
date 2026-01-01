class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i - 1] != nums[i]){
                int l = i + 1;
                int r = nums.length - 1;

                int sum = -nums[i];

                while(l < r){
                    if(nums[l] + nums[r] < sum){
                        l++;
                    }else if(nums[l] + nums[r] > sum){
                        r--;
                    }else{
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[l]);
                        li.add(nums[r]);
                        li.add(nums[i]);

                        ans.add(li);

                        while(l < r && nums[l] + nums[r] == sum){
                            l++;
                        }

                        while(l < r && nums[l] + nums[r] == sum){
                            r--;
                        }
                    }
                }
            }
        }

        return ans;
    }
}