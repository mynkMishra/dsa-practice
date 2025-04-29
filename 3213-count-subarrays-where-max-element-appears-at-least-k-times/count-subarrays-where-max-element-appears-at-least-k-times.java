class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int N = nums.length;
        int max = -1;
        for(int el: nums){
            max = Math.max(max, el);
        }

        int count = 1;
        int l = 0;
        while(l < nums.length){
            if(nums[l] == max){
                break;
            }
            l++;
        }

        int r = k == 1 ? l : l + 1;
        while(r < nums.length && count < k){
            if(nums[r] == max){
                count++;
            }
            if(count == k){
                break;
            }
            r++;
        }
        
        int last = 0;
        long ans = 0;
        while(r < nums.length){
            ans += (long)(N - r)*(long)(l - last + 1);

            l++;
            last = l;
            while(l < nums.length){
                if(nums[l] == max){
                    break;
                }
                l++;
            }

            r++;
            while(r < nums.length){
                if(nums[r] == max){
                    break;
                }
                r++;
            }

        }

        return ans;
    }
}